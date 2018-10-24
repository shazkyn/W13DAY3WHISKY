package com.example.whiskytracker.repositories.distillery;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long>, DistilleryRepositoryCustom {
}
