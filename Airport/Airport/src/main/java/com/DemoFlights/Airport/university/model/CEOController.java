package com.DemoFlights.Airport.university.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ceo")
public class CEOController {
    @Autowired
    private CEORepository ceoRepository;
    @GetMapping
    public List<CEO> getCeo() {
        return ceoRepository.findAll();
    }

    @PostMapping
    public void addCeo(@RequestBody CEO ceo){
        ceoRepository.save(ceo);
    }

}
