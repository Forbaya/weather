package com.forbaya.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ObservationController {
    @GetMapping("/observationpoint/{observationPointId}/observation/{observationId}")
    private String getObservation(@PathVariable Long observationPointId, @PathVariable Long observationId) {
        return "";
    }
}
