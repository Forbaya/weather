package com.forbaya.weather.controller;

import com.forbaya.weather.repository.ObservationPointRepository;
import com.forbaya.weather.service.ObservationPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Controller
public class ObservationController {
    @Autowired
    private ObservationPointRepository observationPointRepository;
    @Autowired
    private ObservationPointService observationPointService;

    @PostConstruct
    private void initializeObservationPoints() {
        observationPointService.add("Tokio", 35.6584421,139.7328635);
        observationPointService.add("Helsinki,", 60.1697530,24.9490830);
        observationPointService.add("New York", 40.7406905,-73.9938438);
        observationPointService.add("Amsterdam", 52.3650691,4.9040238);
        observationPointService.add("Dubai", 25.092535,55.1562243);
    }

    @GetMapping("/observations")
    public String getObservations(Model model) {
        model.addAttribute("observationPoints", observationPointRepository.findAll());
        return "observations";
    }
}
