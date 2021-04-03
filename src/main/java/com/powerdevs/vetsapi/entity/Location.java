package com.powerdevs.vetsapi.entity;


public class Location {
    public double latitude;
    public double longitude;
    public int raio;
   
    public Location (double lat, double lng, int raius){
       latitude = lat;
       longitude = lng;
       raio = raius;
    }

    public String toJSON(){
        return "{\n" +
                "    \"latitude\":"+latitude+",\n" +
                "    \"longitude\":"+longitude+",\n" +
                "    \"raio\": "+raio+"\n" +
                "}";
    }
}
