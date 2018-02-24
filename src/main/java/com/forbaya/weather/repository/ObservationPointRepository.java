package com.forbaya.weather.repository;

import com.forbaya.weather.domain.ObservationPoint;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Account repository interface.
 */
public interface ObservationPointRepository  extends JpaRepository<ObservationPoint, Long> {
    /**
     * Finds an observation point by name.
     *
     * @param city name of the city
     * @return the observation point
     */
    ObservationPoint findByName(String city);

    /**
     * Finds an observation point by id.
     *
     * @param id id of the observation point
     * @return the observation point
     */
    ObservationPoint findById(Long id);
}
