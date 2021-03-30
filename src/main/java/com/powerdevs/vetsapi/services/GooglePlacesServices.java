package com.powerdevs.vetsapi.services;

import com.google.maps.GeoApiContext;

public class GooglePlacesServices {

    private final GeoApiContext.Builder context = new GeoApiContext
            .Builder()
            .apiKey("AIzaSyCK0_iwIReeTUn6NdEiS26vedXlb_Yk1xA");

    public GeoApiContext connexao(){
        return context.build();
    }
}
