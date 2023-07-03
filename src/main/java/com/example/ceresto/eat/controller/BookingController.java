package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Booking;
import com.example.ceresto.eat.model.Customer;
import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.repository.BookingRepository;
import com.example.ceresto.eat.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<String> reserveTable(@RequestBody Booking booking, @RequestParam String username,
                                               @RequestParam Customer customer, @RequestParam DiningTable diningTable){

        // in postman si lascia il json vuoto e si imposta la prenotazione tramite i requestParam nell'url
        // se il tavolo è già prenotato (cioè reserved=true), da errore e si ferma
        if (diningTable.getReserved().equals(true)){
            throw new RuntimeException("Table already reserved");
        } else {
            booking.setCreatedBy(username);
            booking.setCreatedDate(LocalDateTime.now());
            booking.setLastModifiedBy(username);
            booking.setLastModifiedDate(LocalDateTime.now());
            booking.setCustomer(customer);
            booking.setDiningTable(diningTable);
            // il tavolo si cambia direttamente da reserved false a reserved true
            diningTable.setReserved(true);
            bookingRepository.saveAndFlush(booking);
        }
        return ResponseEntity.ok("Table with id " + diningTable.getId() + " reserved for customer with id " + customer.getId());

    }

    @GetMapping("/get-all")
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }
    

    @GetMapping("/get-by-id/{id}")
    public Optional<Booking> getById(@PathVariable("id") Long id) {
        return bookingRepository.findById(id);
    }
    

    @GetMapping ("/get-active-records")
    public Optional<List<Booking>> getActiveRecords(){
        return bookingService.getByStatus(StatusEnum.ACTIVE);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Booking booking, @RequestParam String username) {
        booking.setCreatedBy(bookingRepository.getReferenceById(id).getCreatedBy());
        booking.setCreatedDate(bookingRepository.getReferenceById(id).getCreatedDate());
        booking.setId(bookingRepository.getReferenceById(id).getId());
        booking.setLastModifiedBy(username);
        booking.setLastModifiedDate(LocalDateTime.now());
        bookingRepository.save(booking);
        bookingRepository.deleteById(id);
        return ResponseEntity.ok("Booking with id " + id + " updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        //cancellando la prenotazione del tavolo da reserved=true diventa reserved=false e quindi è riprenotabile
        bookingRepository.getReferenceById(id).getDiningTable().setReserved(false);
        bookingRepository.deleteById(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        bookingRepository.deleteAll();
    }

    @PatchMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatusById(@PathVariable Long id) {
        Booking bookingToSet = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        if (bookingToSet.getStatus().equals(StatusEnum.ACTIVE)) {
            bookingToSet.setStatus(StatusEnum.DELETED);
        } else bookingToSet.setStatus(StatusEnum.ACTIVE);
        bookingRepository.updateStatusById(bookingToSet.getStatus(), id);

        return ResponseEntity.ok("Booking with id " + id + "status changed to " + bookingToSet.getStatus());
    }


}
