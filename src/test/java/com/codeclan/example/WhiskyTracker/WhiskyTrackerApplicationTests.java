package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository WhiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;


	@Test
	public void contextLoads() {
	}


	@Test
	public void canGefindDistilleriesByAge() {
		List<Distillery> foundDistilleries = DistilleryRepository.getDistilleriesForWhiskeyAged12(12);
	}

}
