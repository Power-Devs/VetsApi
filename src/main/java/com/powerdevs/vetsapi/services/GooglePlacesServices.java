package com.powerdevs.vetsapi.services;

import com.google.maps.GeoApiContext;
import com.powerdevs.vetsapi.config.ConfigProperties;

public class GooglePlacesServices {

    private final GeoApiContext.Builder context = new GeoApiContext
            .Builder()
            .apiKey(ConfigProperties.getApiKey());

    public GeoApiContext connexao(){
        return context.build();
    }
}
