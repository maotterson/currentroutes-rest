package com.maotterson.currentroutes.locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<LocationResponse> getLocations(){
        var locations = locationService.getLocations();
        var locationDtoCollection = locations.stream()
                .map(location -> {
                    return toLocationDto(location);
                })
                .toList();
        return ResponseEntity.ok(
                LocationResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("locations",locationDtoCollection))
                        .message("Locations retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    private LocationDto toLocationDto(LocationEntity location){
        return new LocationDto(location.getId(), location.getName(), location.getPlaceId());
    }
}
