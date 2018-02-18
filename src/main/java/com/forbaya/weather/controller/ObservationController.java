package com.forbaya.weather.controller;

import com.forbaya.weather.repository.ObservationPointRepository;
import com.forbaya.weather.service.ObservationPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class ObservationController {
    @GetMapping("/observationpoint/{observationPointId}/observation/{observationId}")
    private String getObservation(@PathVariable Long observationPointId, @PathVariable Long observationId) {
        return "";
    }
}
