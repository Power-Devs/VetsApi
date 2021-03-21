package com.powerdevs.vetsapi.services;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResult;

public class NearbyService {
    GeoApiContext context = new GooglePlacesServices().connexao();
    NearbySearchRequest nearbySearchByLocation;
    Location local;

    public NearbyService(Location location) {
        this.local = location;
    }

    public PlacesSearchResult[] search() throws Exception {
        nearbySearchByLocation = new NearbySearchRequest(new GooglePlacesServices().connexao())
                .location(new LatLng(-23.659847, -46.769564))
                .type(PlaceType.VETERINARY_CARE)
                .radius(800);

        return nearbySearchByLocation.await().results;
    }

}