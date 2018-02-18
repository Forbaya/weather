package com.forbaya.weather.controller;

import com.forbaya.weather.repository.ObservationPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @Autowired
    private ObservationPointRepository observationPointRepository;

    @GetMapping("*")
    public String handleDefault(Model model) {
        model.addAttribute("observationPoints", observationPointRepository.findAll());
        return "index";
    }
}
