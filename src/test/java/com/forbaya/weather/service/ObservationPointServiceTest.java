package com.forbaya.weather.service;

import com.forbaya.weather.domain.ObservationPoint;
import com.forbaya.weather.repository.ObservationPointRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObservationPointServiceTest {
    @Autowired
    private ObservationPointRepository observationPointRepository;
    @Autowired
    private ObservationPointService observationPointService;

    @Test
    public void add() {
        List<ObservationPoint> observationPointList = observationPointRepository.findAll();
        int count = observationPointList.size();
        // There should be 5 initial observation points.
        assertEquals(5, count);

        observationPointService.add("Kumpula", 60.2042758, 24.961099699999977);

        observationPointList = observationPointRepository.findAll();
        count = observationPointList.size();
        assertEquals(6, count);

        ObservationPoint kumpula = observationPointRepository.findByName("Kumpula");
        assertTrue(kumpula.getName().equals("Kumpula"));
        assertEquals(60.2042758, kumpula.getLatitude(), 0.0001);
        assertEquals(24.961099699999977, kumpula.getLongitude(), 0.0001);
    }
}
