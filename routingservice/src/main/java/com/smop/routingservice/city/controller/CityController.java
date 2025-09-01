package com.smop.routingservice.city.controller;

import com.smop.routingservice.city.model.City;
import com.smop.routingservice.city.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "City", description = "City management")
@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @Operation(
        summary = "Get Cities",
        description = "Retrieve Cities for a given city name. Can return mock data for testing.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successfully retrieved cities",
                content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = City.class))
                )
            )
        }
    )
    @GetMapping
    public City[] getPOIs(
        @Parameter(description = "Name of the city to search for")
        @RequestParam String city,
        @Parameter(description = "Flag to indicate if mock data should be returned")
        @RequestParam(defaultValue = "true") boolean isMock) {
        return cityService.getPOIs(city, isMock);
    }
}
