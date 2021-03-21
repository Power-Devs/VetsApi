package com.powerdevs.vetsapi.services;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;

public class GooglePlacesServices {
    @Value("{api.key}")
    private String key;


    private final GeoApiContext.Builder context = new GeoApiContext
            .Builder()
            .apiKey("AIzaSyCK0_iwIReeTUn6NdEiS26vedXlb_Yk1xA");

    public GeoApiContext connexao(){
        return context.build();
    }
}
