package com.smop.routingservice.poi.service;

import com.smop.routingservice.poi.model.POI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class POIServiceImplTest {

    private final POIService poiService = new POIServiceImpl();

    @Test
    void testGetMockPOIsForBerlin() {
        POI[] pois = poiService.getPOIs("Berlin", true);
        
        assertNotNull(pois);
        assertEquals(3, pois.length);
        assertEquals("Berlin", pois[0].getCity());
        assertEquals("Brandenburg Gate", pois[0].getName());
    }

    @Test
    void testGetMockPOIsForParis() {
        POI[] pois = poiService.getPOIs("Paris", true);
        
        assertNotNull(pois);
        assertEquals(3, pois.length);
        assertEquals("Paris", pois[0].getCity());
        assertEquals("Eiffel Tower", pois[0].getName());
    }

    @Test
    void testGetMockPOIsForUnknownCity() {
        POI[] pois = poiService.getPOIs("UnknownCity", true);
        
        assertNotNull(pois);
        assertEquals(1, pois.length);
        assertEquals("UnknownCity", pois[0].getCity());
        assertEquals("City Center", pois[0].getName());
    }

    @Test
    void testGetNonMockPOIs() {
        POI[] pois = poiService.getPOIs("Berlin", false);
        
        assertNotNull(pois);
        assertEquals(0, pois.length); // Empty array for non-mock implementation
    }
}
