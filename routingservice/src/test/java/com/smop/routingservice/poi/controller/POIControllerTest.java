package com.smop.routingservice.poi.controller;

import com.smop.routingservice.poi.model.POI;
import com.smop.routingservice.poi.service.POIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(POIController.class)
@Import(POIControllerTest.TestConfig.class)
class POIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public POIService poiService() {
            return new POIService() {
                @Override
                public POI[] getPOIs(String city, boolean isMock) {
                    if (isMock) {
                        return new POI[]{
                            new POI("1", "Test POI", "Test Description", 52.5, 13.4, "Berlin")
                        };
                    } else {
                        return new POI[0];
                    }
                }
            };
        }
    }

    @Test
    void testGetPOIsWithMockData() throws Exception {
        mockMvc.perform(get("/api/poi")
                .param("city", "Berlin")
                .param("isMock", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Test POI"));
    }

    @Test
    void testGetPOIsWithoutMockData() throws Exception {
        mockMvc.perform(get("/api/poi")
                .param("city", "Berlin")
                .param("isMock", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
