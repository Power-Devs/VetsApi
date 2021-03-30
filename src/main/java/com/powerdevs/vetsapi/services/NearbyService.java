package com.powerdevs.vetsapi.services;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResult;
import com.powerdevs.vetsapi.entity.Location;

public class NearbyService {
    GeoApiContext context = new GooglePlacesServices().connexao();
    NearbySearchRequest nearbySearchByLocation;
//    Location local;

    public NearbyService() {
//        this.local = location;
    }

    public PlacesSearchResult[] search() throws Exception {
        System.out.println(""+local.latitude +" "+local.longitude +" "+local.raio);
        nearbySearchByLocation = new NearbySearchRequest(new GooglePlacesServices().connexao())
                .location(new LatLng(local.latitude, local.longitude))
                .type(PlaceType.VETERINARY_CARE)
                .radius(local.raio);

        return nearbySearchByLocation.await().results;
    }

}