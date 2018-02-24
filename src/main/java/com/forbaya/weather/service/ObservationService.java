package com.forbaya.weather.service;

import com.forbaya.weather.domain.Observation;
import com.forbaya.weather.domain.ObservationPoint;
import com.forbaya.weather.repository.ObservationPointRepository;
import com.forbaya.weather.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import javax.transaction.Transactional;

@Service
public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;
    @Autowired
    private ObservationPointRepository observationPointRepository;

    /**
     * Adds a new observation to the database.
     *
     * @param observationPoint the observation point
     * @param temperature      the temperature
     */
    @Transactional
    public void add(ObservationPoint observationPoint, double temperature) {
        Observation observation = new Observation();
        observation.setObservationPoint(observationPoint);
        observation.setTemperature(temperature);
        observation.setDate(new Date());

        observationRepository.save(observation);

        observationPoint.getObservations().add(observation);
        observationPointRepository.save(observationPoint);
    }
}
