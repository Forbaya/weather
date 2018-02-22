package com.forbaya.weather.service;

import com.forbaya.weather.domain.ObservationPoint;
import com.forbaya.weather.repository.ObservationPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ObservationPointService {
    @Autowired
    private ObservationPointRepository observationPointRepository;

    @Transactional
    public void add(String name, double latitude, double longitude) {
        if (observationPointRepository.findByName(name) == null) {
            ObservationPoint observationPoint = new ObservationPoint();
            observationPoint.setName(name);
            observationPoint.setLatitude(latitude);
            observationPoint.setLongitude(longitude);

            observationPointRepository.save(observationPoint);
        }
    }
}
