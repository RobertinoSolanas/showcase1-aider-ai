package com.smop.routingservice.city.service;

import com.smop.routingservice.city.model.City;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Override
    public City[] getPOIs(String city, boolean isMock) {
        if (isMock) {
            return getMockCities(city);
        } else {
            // For non-mock, we could implement real logic here
            // For now, returning empty array
            return new City[0];
        }
    }

    private City[] getMockCities(String city) {
        switch (city.toLowerCase()) {
            case "berlin":
                return new City[]{
                    new City("1", "Berlin", "Germany", "Capital of Germany", 52.5200, 13.4050)
                };
            case "paris":
                return new City[]{
                    new City("2", "Paris", "France", "Capital of France", 48.8566, 2.3522)
                };
            case "london":
                return new City[]{
                    new City("3", "London", "United Kingdom", "Capital of United Kingdom", 51.5074, -0.1278)
                };
            default:
                return new City[0];
        }
    }
}
