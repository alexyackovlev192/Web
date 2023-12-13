package com.dreamer.webap.controllers;

import com.dreamer.webap.models.Users;
import com.dreamer.webap.repository.BookingRepo;
import com.dreamer.webap.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookingRepo bookingRepo;
    @GetMapping("/account/profile")
    public String profile(Model model) {
        model.addAttribute("title", "Profile");

        Users data = userRepo.findByUsername("alexa");
        model.addAttribute("data", data);

        return "/account/account-profile-page";
    }

    @GetMapping("/account/settings")
    public String settings(Model model) {
        model.addAttribute("title", "Settings");

        Users dataS = userRepo.findByUsername("alexa");
        model.addAttribute("data", dataS);

        return "/account/account-settings-page";
    }


    @PostMapping("/account/settings")
    public String saveSettings(@ModelAttribute Users updatedUser, Model model) {
        if (updatedUser != null) {
            Users currentUser = userRepo.findByUsername("alexa");
            if (currentUser != null) {

                currentUser.setUsername(updatedUser.getUsername());
                currentUser.setFull_Name(updatedUser.getFull_Name());
                currentUser.setEmail(updatedUser.getEmail());

                userRepo.save(currentUser);
            }
        }

        return "/account/account-settings-page";
    }

    @GetMapping("/account/history")
    public String history(Users user, Model model) {
        model.addAttribute("title", "Booking history");

        Iterable<Object[]> dataH = bookingRepo.findBookings(1);
        model.addAttribute("data", dataH);

        return "/account/account-booking-history-page";
    }

    @GetMapping("/account/active_bookings")
    public String active_bookings(Users user, Model model) {
        model.addAttribute("title", "Active Bookings");

        Iterable<Object[]>  dataA = bookingRepo.findActiveBookings(2);
        model.addAttribute("data", dataA);

        return "/account/account-active-bookings-page";
    }
}

//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            String username = authentication.getName();
//            Users data = userRepo.findByUsername(username);
//            model.addAttribute("data", data);
//        }
