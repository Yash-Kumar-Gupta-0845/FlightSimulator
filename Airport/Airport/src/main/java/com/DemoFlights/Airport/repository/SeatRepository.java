package com.DemoFlights.Airport.repository;

import com.DemoFlights.Airport.model.Flight;
import com.DemoFlights.Airport.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByFlightId(Long flightId);
}
