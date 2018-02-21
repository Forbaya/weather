package com.forbaya.weather.controller;

import com.forbaya.weather.repository.ObservationPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class HeaderControllerAdvice {
    @Autowired
    private ObservationPointRepository observationPointRepository;

    @ModelAttribute
    public String showObservationPoints(Model model) {
        model.addAttribute("observationPoints", observationPointRepository.findAll());
        return "fragments/header :: header";
    }
}
