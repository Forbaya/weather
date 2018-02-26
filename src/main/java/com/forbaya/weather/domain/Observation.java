package com.forbaya.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Observation extends AbstractPersistable<Long> {
    @ManyToOne
    @JoinColumn(name = "observation_point_id")
    private ObservationPoint observationPoint;
    private double temperature;
    private Date date;
}
