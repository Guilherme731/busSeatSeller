package com.cyber.busSeatSeller.controllers;
import com.cyber.busSeatSeller.entities.Seat;
import com.cyber.busSeatSeller.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/bus/seats")
    public String getSeats(Model model){
        model.addAttribute("seatsList", seatRepository.findAll());
        return "bus/seats/index";
    }
}
