package com.DemoFlights.Airport.controller;

import com.DemoFlights.Airport.model.Airline;
import com.DemoFlights.Airport.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    @Autowired
    AirlineRepository airlineRepository;
    @GetMapping
    public List<Airline> getAirlines() {
        return airlineRepository.findAll();
    }

    @PostMapping
    public Airline addAirline(@RequestBody Airline airline) {
        return airlineRepository.save(airline);
    }


}
