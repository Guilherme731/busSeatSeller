package com.cyber.busSeatSeller.controllers;
import com.cyber.busSeatSeller.entities.Seat;
import com.cyber.busSeatSeller.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/bus/seats")
    public String getSeats(Model model){
        model.addAttribute("seatsList", seatRepository.findAll());
        return "bus/seats/index";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("seatsList", seatRepository.findAll());
        return "/index";
    }

    @GetMapping("/bus/seats/{id}")
    public String editSeat(@PathVariable("id") long seatId, Model model){
        Optional<Seat> optionalSeat = seatRepository.findById(seatId);
        if(optionalSeat.isEmpty()){
            throw new IllegalArgumentException("Seat not exists.");
        }
        model.addAttribute("seat", optionalSeat.get());
        return "bus/seats/editProperty";
    }

    @GetMapping("/bus/seats/{id}/defineVacant")
    public String editSeatProperty(@PathVariable("id") long seatId, Model model){
        Optional<Seat> optionalSeat = seatRepository.findById(seatId);
        if(optionalSeat.isEmpty()){
            throw new IllegalArgumentException("Seat not exists.");
        }
        Seat seat = optionalSeat.get();
        seat.setVacant(true);
        seat.setAnonymous(false);
        seat.setOwner(null);
        seat.setSellPrice(0);
        seat.setLastSellAt(null);
        return "redirect:/bus/seats";
    }

    @PostMapping("/bus/seats/saveEdit")
    public String saveEdit(@ModelAttribute("seat") Seat seat){
        seat.setVacant(false);
        seat.setLastSellAt(LocalDate.now());
        seatRepository.save(seat);
        return "redirect:/bus/seats";
    }
}
