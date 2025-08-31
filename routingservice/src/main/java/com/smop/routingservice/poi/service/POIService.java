package com.smop.routingservice.poi.service;

import com.smop.routingservice.poi.model.POI;

public interface POIService {
    POI[] getPOIs(String city, boolean isMock);
}
