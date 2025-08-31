package com.smop.routingservice.poi.controller;

import com.smop.routingservice.poi.model.POI;
import com.smop.routingservice.poi.service.POIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(POIController.class)
class POIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private POIService poiService;

    @Test
    void testGetPOIsWithMockData() throws Exception {
        POI[] mockPOIs = {
            new POI("1", "Test POI", "Test Description", 52.5, 13.4, "Berlin")
        };
        
        when(poiService.getPOIs("Berlin", true)).thenReturn(mockPOIs);

        mockMvc.perform(get("/api/poi")
                .param("city", "Berlin")
                .param("isMock", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Test POI"));
    }

    @Test
    void testGetPOIsWithoutMockData() throws Exception {
        when(poiService.getPOIs("Berlin", false)).thenReturn(new POI[0]);

        mockMvc.perform(get("/api/poi")
                .param("city", "Berlin")
                .param("isMock", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
