package com.example.ceresto.eat.controller;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Booking;
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
    public ResponseEntity<String> createBooking (@RequestBody Booking booking, @RequestParam String username) {
        booking.setCreatedBy(username);
        booking.setCreatedDate(LocalDateTime.now());
        booking.setLastModifiedBy(username);
        booking.setLastModifiedDate(LocalDateTime.now());
        bookingRepository.saveAndFlush(booking);
        return ResponseEntity.ok("Booking created successfully");
    }

    @GetMapping("/get-all")
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

//    @GetMapping("/get-by-customer/{customer}")
//    public ResponseEntity<Booking> getByCustomer(@PathVariable("customer") Customer customer_id) {
//        Optional<Booking> booking = bookingRepository.getByCustomer(customer_id);
//        return booking.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Booking> getById(@PathVariable("id") Long id) {
        return bookingRepository.findById(id);
    }

//    @GetMapping("/get-by-diningTable/{diningTable}")
//    public ResponseEntity<List<Booking>> getByType(@PathVariable("diningTable") DiningTable diningTable) {
//        Optional<List<Booking>> bookingList = bookingService.getByType(diningTable);
//        return bookingList.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @GetMapping ("/get-active-records")
    public Optional<List<Booking>> getActiveRecords(){
        return bookingService.getByStatus(StatusEnum.ACTIVE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Booking booking, @RequestParam String username) {
        bookingRepository.deleteById(id);
        booking.setLastModifiedBy(username);
        booking.setLastModifiedDate(LocalDateTime.now());
        bookingRepository.save(booking);
        return ResponseEntity.ok("Booking with id " + id + " updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
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
