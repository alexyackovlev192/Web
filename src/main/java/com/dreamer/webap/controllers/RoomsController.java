package com.dreamer.webap.controllers;

import com.dreamer.webap.models.Rooms;
import com.dreamer.webap.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomsController {
    private final RoomRepo repoRoom;

    @Autowired
    public RoomsController(RoomRepo repoRoom) {
        this.repoRoom = repoRoom;
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        Iterable<Rooms> rooms = repoRoom.findAll();
        model.addAttribute("title", "Hotel Rooms");
        model.addAttribute("rooms", rooms);
        return "rooms-page";
    }
}
