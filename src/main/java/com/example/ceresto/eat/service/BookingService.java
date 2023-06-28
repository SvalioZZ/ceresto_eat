package com.example.ceresto.eat.service;

import com.example.ceresto.eat.enumerati.CourseTypeEnum;
import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.Booking;
import com.example.ceresto.eat.model.CourseDetails;
import com.example.ceresto.eat.model.DiningTable;
import com.example.ceresto.eat.repository.BookingRepo;
import com.example.ceresto.eat.repository.CourseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    public BookingService(BookingRepo BookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Optional<List<Booking>> getByType(DiningTable diningTable){
        return bookingRepo.getByType(diningTable);
    }

    public Optional<List<Booking>> getByStatus(StatusEnum status){
        return bookingRepo.getByStatus(status);
    }
}

