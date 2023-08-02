package com.DemoFlights.Airport.controller;

import com.DemoFlights.Airport.model.Flight;
import com.DemoFlights.Airport.model.Seat;
import com.DemoFlights.Airport.repository.FlightRepository;
import com.DemoFlights.Airport.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights/{flightId}/seats")
public class SeatController {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    SeatRepository seatRepository;
    @GetMapping
    public ResponseEntity<List<Seat>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<Seat> seats = seatRepository.findByFlightId(flightId);
        return ResponseEntity.ok(seats);
    }

    @PostMapping
    public ResponseEntity<List<Seat>> addSeatsByFlightId(@PathVariable Long flightId, @RequestBody List<Seat> seats) {
        Flight flight = flightRepository.findById(flightId).get();
        seats = seats.stream().map(s -> {s.setFlight(flight); return s;}).toList();
        List<Seat> seats1 = seatRepository.saveAll(seats);
        return ResponseEntity.ok(seats1);
    }
}
