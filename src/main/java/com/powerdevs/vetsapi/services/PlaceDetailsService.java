package com.powerdevs.vetsapi.services;

import com.google.maps.PlaceDetailsRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlaceDetails;

import java.io.IOException;

public class PlaceDetailsService {
    private String id;
    PlaceDetailsRequest places = new PlaceDetailsRequest(new GooglePlacesServices().connexao());

    public PlaceDetailsService(String id) {
        this.id = id;
         places.placeId(id).language("pt-BR");
    }

    public PlaceDetails details() throws InterruptedException, ApiException, IOException {
        return places.await();
    }
}

/*
    Seria interessante retornar:

    formattedAddress
    formattedPhoneNumber
    name
    openingHours
    userRatingsTotal
    rating
    reviews
    vicinity
    website
 */
