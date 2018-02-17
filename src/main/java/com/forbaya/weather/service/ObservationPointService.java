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
    public void add(String city, double latitude, double longitude) {
        ObservationPoint observationPoint = new ObservationPoint();
        observationPoint.setCity(city);
        observationPoint.setLatitude(latitude);
        observationPoint.setLongitude(longitude);

        observationPointRepository.save(observationPoint);
    }
}
