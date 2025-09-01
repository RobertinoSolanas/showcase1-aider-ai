package com.smop.routingservice.city.service;

import com.smop.routingservice.city.model.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceImplTest {

    private final CityService cityService = new CityServiceImpl();

    @Test
    void testGetMockCitiesForBerlin() {
        City[] cities = cityService.getPOIs("Berlin", true);

        assertNotNull(cities);
        assertEquals(1, cities.length);
        assertEquals("Berlin", cities[0].getName());
        assertEquals("Germany", cities[0].getCountry());
    }

    @Test
    void testGetMockCitiesForParis() {
        City[] cities = cityService.getPOIs("Paris", true);

        assertNotNull(cities);
        assertEquals(1, cities.length);
        assertEquals("Paris", cities[0].getName());
        assertEquals("France", cities[0].getCountry());
    }

    @Test
    void testGetMockCitiesForLondon() {
        City[] cities = cityService.getPOIs("London", true);

        assertNotNull(cities);
        assertEquals(1, cities.length);
        assertEquals("London", cities[0].getName());
        assertEquals("United Kingdom", cities[0].getCountry());
    }

    @Test
    void testGetMockCitiesForUnknownCity() {
        City[] cities = cityService.getPOIs("Unknown", true);

        assertNotNull(cities);
        assertEquals(0, cities.length);
    }

    @Test
    void testGetNonMockCities() {
        City[] cities = cityService.getPOIs("Berlin", false);

        assertNotNull(cities);
        assertEquals(0, cities.length);
    }
}
