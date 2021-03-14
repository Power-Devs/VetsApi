package com.powerdevs.vetsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SobreController {
    @GetMapping("/sobre")
    public String sobreVets(){return "Vets é o bicho";}
}
