package com.forbaya.weather.repository;

import com.forbaya.weather.domain.Observation;
import com.forbaya.weather.domain.ObservationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
    @Query(value = "SELECT * FROM observation WHERE observation_point_id = ?1 ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Observation findCurrentObservationIn(Long observationPointId);
}
