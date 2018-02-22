package com.forbaya.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Observation extends AbstractPersistable<Long> {
    @Column(length = 10000)
    private ObservationPoint observationPoint;
    private double temperature;
    private Date date;
}
