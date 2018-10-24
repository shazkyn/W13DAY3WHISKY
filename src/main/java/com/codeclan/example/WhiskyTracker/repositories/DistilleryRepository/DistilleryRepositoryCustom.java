package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;

import javax.swing.plaf.synth.Region;
import java.util.List;

public interface DistilleryRepositoryCustom {

    List<Distillery> findDistilleriesByRegion(String region);

    List<Distillery> findDistilleriesByAge(int age);



}
