package com.forbaya.weather.repository;

import com.forbaya.weather.domain.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
