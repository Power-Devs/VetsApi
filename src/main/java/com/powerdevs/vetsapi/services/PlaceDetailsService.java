package com.powerdevs.vetsapi.services;

import com.google.maps.PlaceDetailsRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlaceDetails;

import java.io.IOException;

public class PlaceDetailsService {

    PlaceDetailsRequest places = new PlaceDetailsRequest(new GooglePlacesServices().connexao());

    public PlaceDetailsService(String id) {

        places.placeId(id).language("pt-BR").fields(
                PlaceDetailsRequest.FieldMask.ADR_ADDRESS,
                PlaceDetailsRequest.FieldMask.FORMATTED_ADDRESS,
                PlaceDetailsRequest.FieldMask.FORMATTED_PHONE_NUMBER,
                PlaceDetailsRequest.FieldMask.GEOMETRY_LOCATION,
                PlaceDetailsRequest.FieldMask.NAME,
                PlaceDetailsRequest.FieldMask.OPENING_HOURS,
                PlaceDetailsRequest.FieldMask.PHOTOS,
                PlaceDetailsRequest.FieldMask.PLACE_ID,
                PlaceDetailsRequest.FieldMask.PERMANENTLY_CLOSED,
                PlaceDetailsRequest.FieldMask.USER_RATINGS_TOTAL,
                PlaceDetailsRequest.FieldMask.RATING,
                PlaceDetailsRequest.FieldMask.REVIEW,
                PlaceDetailsRequest.FieldMask.TYPES,
                PlaceDetailsRequest.FieldMask.VICINITY,
                PlaceDetailsRequest.FieldMask.BUSINESS_STATUS
        );
    }

    public PlaceDetails details() throws InterruptedException, ApiException, IOException {
        return places.await();
    }
}
