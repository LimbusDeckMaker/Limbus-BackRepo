package com.example.demo.Controller;

import com.example.demo.domain.Sinner;
import com.example.demo.repository.SinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sinners")
public class SinnerController {
    @Autowired
    private SinnerRepository sinnerRepository;

    @GetMapping
    public List<Sinner> getAllSinners() {
        return sinnerRepository.findAll();
    }

    // Other CRUD methods
}
