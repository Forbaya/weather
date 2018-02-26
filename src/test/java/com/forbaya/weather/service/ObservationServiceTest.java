package com.forbaya.weather.service;

import com.forbaya.weather.domain.Observation;
import com.forbaya.weather.domain.ObservationPoint;
import com.forbaya.weather.repository.ObservationPointRepository;
import com.forbaya.weather.repository.ObservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObservationServiceTest {
    @Autowired
    private ObservationService observationService;
    @Autowired
    private ObservationRepository observationRepository;
    @Autowired
    private ObservationPointRepository observationPointRepository;

    @Test
    public void add() {
        List<Observation> observationList = observationRepository.findAll();
        int count = observationList.size();
        assertEquals(0, count);

        ObservationPoint observationPoint = observationPointRepository.findByName("Helsinki");
        observationService.add(observationPoint, -5);

        observationList = observationRepository.findAll();
        count = observationList.size();
        assertEquals(1, count);

        Observation observation = observationList.get(0);
        ObservationPoint helsinkiObservationPoint = observation.getObservationPoint();
        assertEquals("Helsinki", helsinkiObservationPoint.getName());
        assertEquals(-5, observation.getTemperature(), 0.001);
    }
}
