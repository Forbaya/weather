package com.forbaya.weather.controller;

import com.forbaya.weather.domain.ObservationPoint;
import com.forbaya.weather.repository.ObservationPointRepository;
import com.forbaya.weather.service.ObservationPointService;
import com.forbaya.weather.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class ObservationPointController {
    @Autowired
    private ObservationPointRepository observationPointRepository;
    @Autowired
    private ObservationPointService observationPointService;
    @Autowired
    private ObservationService observationService;

    /**
     * Initializes the observation points for h2 database.
     */
    @PostConstruct
    private void initializeObservationPoints() {
        observationPointService.add("Tokio", 35.6584421,139.7328635);
        observationPointService.add("Helsinki", 60.1697530,24.9490830);
        observationPointService.add("New York", 40.7406905,-73.9938438);
        observationPointService.add("Amsterdam", 52.3650691,4.9040238);
        observationPointService.add("Dubai", 25.092535,55.1562243);
    }

    /**
     * Handles the GET-method for URL /observationpoint/{id}.
     *
     * @param model the model
     * @param id    id of the observation point
     * @return observation-point.html
     */
    @GetMapping("/observationpoint/{id}")
    public String getObservationPoint(Model model, @PathVariable Long id) {
        model.addAttribute("observationPoint", observationPointRepository.findById(id));
        return "observation-point";
    }

    @PostMapping("/observationpoint/{id}")
    public String postObservationPoint(@PathVariable Long id, @RequestParam double temperature) {
        ObservationPoint observationPoint = observationPointRepository.findById(id);
        observationService.add(observationPoint, temperature);
        return "redirect:/observationpoint/" + id;
    }
}
