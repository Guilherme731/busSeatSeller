package com.cyber.busSeatSeller.repositories;

import com.cyber.busSeatSeller.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

}
