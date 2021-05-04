package com.powerdevs.vetsapi.controller;

import com.google.maps.model.PlacesSearchResult;
import com.powerdevs.vetsapi.entity.Location;
import com.powerdevs.vetsapi.services.NearbyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @GetMapping("/location")
    @ResponseBody
    public ResponseEntity< PlacesSearchResult[]> getLocations(@RequestBody Location local) throws Exception {
        NearbyService Localiza = new NearbyService(local);


        return new ResponseEntity<>(Localiza.search(), HttpStatus.OK);

    }
}