package com.powerdevs.vetsapi.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.maps.model.PlacesSearchResult;
import com.powerdevs.vetsapi.entity.Location;
import com.powerdevs.vetsapi.services.NearbyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @GetMapping(value = "/location", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @JsonIgnore
    public ResponseEntity<PlacesSearchResult[]> getLocations(@RequestBody @Nullable Location local) throws Exception {
        NearbyService localiza = new NearbyService(local);

        return new ResponseEntity<>(localiza.search(), HttpStatus.OK);

    }
}