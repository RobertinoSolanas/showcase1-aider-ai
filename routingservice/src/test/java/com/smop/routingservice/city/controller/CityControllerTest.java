package com.smop.routingservice.city.controller;

import com.smop.routingservice.city.model.City;
import com.smop.routingservice.city.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CityController.class)
@Import(CityControllerTest.TestConfig.class)
class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public CityService cityService() {
            return new CityService() {
                @Override
                public City[] getPOIs(String city, boolean isMock) {
                    if (isMock) {
                        return new City[]{
                            new City("1", "Test City", "Test Country", "Test Description", 52.5, 13.4)
                        };
                    } else {
                        return new City[0];
                    }
                }
            };
        }
    }

    @Test
    void testGetCitiesWithMockData() throws Exception {
        mockMvc.perform(get("/api/city")
                .param("city", "Berlin")
                .param("isMock", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Test City"));
    }

    @Test
    void testGetCitiesWithoutMockData() throws Exception {
        mockMvc.perform(get("/api/city")
                .param("city", "Berlin")
                .param("isMock", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
