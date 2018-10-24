package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping(value = "/distilleries")
    public class DistilleryController {

        @Autowired
        com.example.whiskytracker.repositories.distillery.DistilleryRepository distilleryRepository;

        @GetMapping(value = "/filterRegion/{region}")
        public List<Distillery> findDistilleriesByRegion(@PathVariable String region){
            return distilleryRepository.findDistilleriesByRegion(region);
        }

        @GetMapping(value = "/filterAge/{age}")
        public List<Distillery> findDistilleriesByAge(@PathVariable int age){
            return distilleryRepository.findDistilleriesByAge(age);
        }

}
