package com.powerdevs.vetsapi.controller;

import java.io.Serializable;

import com.powerdevs.vetsapi.entity.Location;
import com.powerdevs.vetsapi.services.NearbyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @GetMapping("/location")
    @ResponseBody
    public Serializable getLocations(@RequestBody Location local){
        NearbyService Localiza = new NearbyService(local);

        try{
           return Localiza.search();
        } catch (Exception e) {
            return e.getMessage();
        }
        }
}
