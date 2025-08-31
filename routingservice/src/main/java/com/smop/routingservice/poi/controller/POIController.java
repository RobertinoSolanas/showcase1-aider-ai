package com.smop.routingservice.poi.controller;

import com.smop.routingservice.poi.model.POI;
import com.smop.routingservice.poi.service.POIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "POI", description = "Points of Interest management")
@RestController
@RequestMapping("/api/poi")
@RequiredArgsConstructor
public class POIController {

    private final POIService poiService;

    @Operation(
        summary = "Get Points of Interest",
        description = "Retrieve Points of Interest for a given city. Can return mock data for testing.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successfully retrieved POIs",
                content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = POI.class))
                )
            )
        }
    )
    @GetMapping
    public POI[] getPOIs(
            @Parameter(description = "City name to get POIs for", example = "Berlin")
            @RequestParam String city,
            @Parameter(description = "Whether to return mock data", example = "true")
            @RequestParam(defaultValue = "false") boolean isMock) {
        return poiService.getPOIs(city, isMock);
    }
}
