package com.example.whiskytracker.repositories.whisky;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long>, com.example.whiskytracker.repositories.whisky.WhiskyRepositoryCustom {
    public List<Whisky> findWhiskiesByYear(int year);
}
