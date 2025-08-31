package com.smop.routingservice.poi.service;

import com.smop.routingservice.poi.model.POI;
import org.springframework.stereotype.Service;

@Service
public class POIServiceImpl implements POIService {

    @Override
    public POI[] getPOIs(String city, boolean isMock) {
        if (isMock) {
            return getMockPOIs(city);
        }
        // In a real implementation, you would fetch from a database or external service
        return new POI[0];
    }

    private POI[] getMockPOIs(String city) {
        switch (city.toLowerCase()) {
            case "berlin":
                return new POI[]{
                    new POI("1", "Brandenburg Gate", "Historic landmark", 52.5163, 13.3777, "Berlin"),
                    new POI("2", "Berlin Cathedral", "Protestant cathedral", 52.5190, 13.4014, "Berlin"),
                    new POI("3", "Museum Island", "UNESCO World Heritage site", 52.5208, 13.3978, "Berlin")
                };
            case "paris":
                return new POI[]{
                    new POI("4", "Eiffel Tower", "Iconic iron lattice tower", 48.8584, 2.2945, "Paris"),
                    new POI("5", "Louvre Museum", "World's largest art museum", 48.8606, 2.3376, "Paris"),
                    new POI("6", "Notre-Dame", "Medieval Catholic cathedral", 48.8530, 2.3499, "Paris")
                };
            case "london":
                return new POI[]{
                    new POI("7", "Big Ben", "Iconic clock tower", 51.4994, -0.1245, "London"),
                    new POI("8", "Tower of London", "Historic castle", 51.5085, -0.0766, "London"),
                    new POI("9", "Buckingham Palace", "Royal residence", 51.5014, -0.1419, "London")
                };
            default:
                return new POI[]{
                    new POI("10", "City Center", "Central point of " + city, 0.0, 0.0, city)
                };
        }
    }
}
