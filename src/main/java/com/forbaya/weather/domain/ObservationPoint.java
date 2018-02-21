package com.forbaya.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ObservationPoint extends AbstractPersistable<Long> {
    private String name;
    private double latitude;
    private double longitude;
    @OneToMany(fetch = FetchType.EAGER)
    List<Observation> observations;
}
