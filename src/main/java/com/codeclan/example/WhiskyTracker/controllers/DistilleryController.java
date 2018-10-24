package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.synth.Region;
import java.util.List;
import java.util.Locale;

@RestController
    @RequestMapping(value = "/distilleries")
    public class DistilleryController {

        @Autowired
        DistilleryRepository distilleryRepository;

        @GetMapping(value = "/filterRegion/{region}")
        public List<Distillery> findDistilleriesByRegion(@PathVariable String region){
            return distilleryRepository.findDistilleriesByRegion(Region.valueOf(region.toUpperCase(Locale.ENGLISH)));
        }

//        @GetMapping(value = "/filterAge/{age}")
//        public List<Distillery> findDistilleriesByAge(@PathVariable int age){
//            return distilleryRepository.findDistilleriesByAge(age);
//        }

}
