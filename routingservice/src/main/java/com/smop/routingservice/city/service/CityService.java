package com.smop.routingservice.city.service;

import com.smop.routingservice.city.model.City;

public interface CityService {
    City[] getPOIs(String city, boolean isMock);
}
