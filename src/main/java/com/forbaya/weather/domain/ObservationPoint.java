package com.forbaya.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ObservationPoint extends AbstractPersistable<Long> {
    private String city;
    private double latitude;
    private double longitude;
}
