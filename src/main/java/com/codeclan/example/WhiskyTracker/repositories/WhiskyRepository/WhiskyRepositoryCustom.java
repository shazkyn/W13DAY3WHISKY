package com.example.whiskytracker.repositories.whisky;



import com.codeclan.example.WhiskyTracker.models.Whisky;
import javax.swing.plaf.synth.Region;
import java.util.List;

public interface WhiskyRepositoryCustom {
    public List<Whisky> findWhiskiesByYear(int year);

    List<Whisky> findWhiskiesByYear(int year);

    List<Whisky> findWhiskiesByRegion(Region region);

    List<Whisky> findWhiskiesByAgeAndRegion(int age , Region region);

}