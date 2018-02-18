package com.forbaya.weather.repository;

import com.forbaya.weather.domain.ObservationPoint;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Account repository interface.
 */
public interface ObservationPointRepository  extends JpaRepository<ObservationPoint, Long> {
    /**
     * Finds an observation point by city name.
     *
     * @param city name of the city
     * @return the observation point of the city
     */
    ObservationPoint findByName(String city);

    ObservationPoint findById(Long id);
}
