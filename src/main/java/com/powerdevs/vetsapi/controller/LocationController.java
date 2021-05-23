package com.powerdevs.vetsapi.controller;

import com.google.maps.model.PlacesSearchResult;
import com.powerdevs.vetsapi.entity.Location;
import com.powerdevs.vetsapi.services.NearbyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {
    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PlacesSearchResult[]> getLocations(
            @RequestParam @Nullable String lat,
            @RequestParam @Nullable String lng,
            @RequestParam @Nullable String raio,
            @RequestBody @Nullable Location local
    ) throws Exception {

        if(lat!=null && lng !=null){
            local = new Location(
                    Double.parseDouble(lat),
                    Double.parseDouble(lng),
                    raio == null ? 8000 : Integer.parseInt(raio)
            );
        }

        NearbyService localiza = new NearbyService(local);

        return new ResponseEntity<>(localiza.search(), HttpStatus.OK);

    }
}