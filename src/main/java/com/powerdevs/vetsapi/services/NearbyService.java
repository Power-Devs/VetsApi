package com.powerdevs.vetsapi.services;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResult;
import com.powerdevs.vetsapi.entity.Location;

public class NearbyService {
    private GeoApiContext context = new GooglePlacesServices().connexao();
    private NearbySearchRequest nearbySearchByLocation;
    private Location local;

    public NearbyService(Location location) {
        this.local = location;
    }
    public PlacesSearchResult[] search() throws Exception {

        nearbySearchByLocation = new NearbySearchRequest(new GooglePlacesServices().connexao())
                .location(new LatLng(local.latitude, local.longitude))
                .type(PlaceType.VETERINARY_CARE)
                .radius(local.raio);

        return nearbySearchByLocation.await().results;
    }

}