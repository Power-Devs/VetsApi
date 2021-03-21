package com.powerdevs.vetsapi.controller;

import com.google.maps.model.PlaceDetails;
import com.powerdevs.vetsapi.services.PlaceDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailsController {

    @GetMapping("/details")
    @ResponseBody
    public PlaceDetails clinicDetails(@RequestParam String id) throws Exception {
        PlaceDetailsService detailsService = new PlaceDetailsService(id);
        return detailsService.details();
    }
}
