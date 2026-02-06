package com.cyber.busSeatSeller;

import com.cyber.busSeatSeller.entities.Seat;
import com.cyber.busSeatSeller.repositories.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class SeedDatabase implements CommandLineRunner {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i = 1; i <= 18; i++){
            Seat seat = new Seat(i);
            seat.setAnonymous(false);
            seat.setPriceToBuy(25);
            seat.setVacant(true);

            seatRepository.save(seat);
        }
    }
}
