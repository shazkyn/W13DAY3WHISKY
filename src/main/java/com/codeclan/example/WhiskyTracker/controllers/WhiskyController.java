package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.synth.Region;
import java.util.List;
import java.util.Locale;


@RestController
    @RequestMapping(value = "/whiskies")
    public class WhiskyController {

        @Autowired
        WhiskyRepository whiskyRepository;

        @GetMapping(value = "/filterYear/{year}")
        public List<Whisky> findWhiskiesByYear(@PathVariable int year){
            return whiskyRepository.findWhiskiesByYear(year);
        }

        @GetMapping(value = "/filterRegion/{region}")
        public List<Whisky> findWhiskiesByRegion(@PathVariable String region){
            return whiskyRepository.findWhiskiesByRegion(Region.valueOf(region.toUpperCase(Locale.ENGLISH)));
        }

        @GetMapping(value = "/filter/{age}/{region}")
        public List<Whisky> findWhiskyByAgeAndRegion(@PathVariable int age, @PathVariable String region){
            return whiskyRepository.findWhiskiesByAgeAndRegion(age, Region.valueOf(region.toUpperCase(Locale.ENGLISH)));
        }


    }
