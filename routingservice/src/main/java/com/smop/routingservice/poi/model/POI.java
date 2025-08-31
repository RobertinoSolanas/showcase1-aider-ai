package com.smop.routingservice.poi.model;

import lombok.Data;

@Data
public class POI {
    private String id;
    private String name;
    private String description;
    private double latitude;
    private double longitude;
    private String city;
    
    public POI() {}
    
    public POI(String id, String name, String description, double latitude, double longitude, String city) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }
}
