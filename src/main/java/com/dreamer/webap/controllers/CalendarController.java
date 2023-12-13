package com.dreamer.webap.controllers;

import com.dreamer.webap.repository.BookingRepo;
import com.dreamer.webap.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class CalendarController {

    @Autowired
    private BookingRepo repoBooking;
    @Autowired
    private RoomRepo repoRoom;
    @GetMapping("/calendar/{roomId}")
    public String calendar(@PathVariable Integer roomId, Model model) {
        List<Date> startDates = repoBooking.findDistinctStartDatesByID(roomId);
        List<Date> endDates = repoBooking.findDistinctEndDatesByID(roomId);
        Integer number = repoRoom.findNumberByID(roomId);

        Set<Date> reservedDatesSet = new HashSet<>();
        reservedDatesSet.addAll(startDates);
        reservedDatesSet.addAll(endDates);

        List<Date> reservedDates = new ArrayList<>(reservedDatesSet);

        model.addAttribute("number", number);
        model.addAttribute("reservedDates", reservedDates);
        model.addAttribute("title", "Planning page");

        return "calendar-booking-page";
    }
}


