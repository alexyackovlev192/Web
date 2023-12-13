package com.dreamer.webap.controllers;

import com.dreamer.webap.models.Bookings;
import com.dreamer.webap.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingsController {
    private final BookingRepo repoBooking;

    @Autowired
    public BookingsController(BookingRepo repoBooking) {
        this.repoBooking = repoBooking;
    }

    @GetMapping("/bookings")
    public String bookings(Model model) {
        Iterable<Bookings> bookings = repoBooking.findAll();
        model.addAttribute("bookings", bookings);
        return "bookings-page";
    }
}
