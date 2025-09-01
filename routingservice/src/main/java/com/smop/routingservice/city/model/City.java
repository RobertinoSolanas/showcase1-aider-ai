package com.smop.routingservice.city.model;

import lombok.Data;

@Data
public class City {
    private String id;
    private String name;
    private String country;
    private String description;
    private double latitude;
    private double longitude;

    public City() {
    }

    public City(String id, String name, String country, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
