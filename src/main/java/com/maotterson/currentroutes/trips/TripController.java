package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.directions.DirectionsHelpers;
import com.maotterson.currentroutes.locations.LocationHelpers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.Location;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<TripResponse> getAllTrips(){
        var trips = tripService.getAllTrips();
        var tripDtoCollection = trips.stream()
                .map(trip -> {
                    return toTripDto(trip);
                })
                .toList();
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(tripDtoCollection)
                        .message("Trips retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    private TripDto toTripDto(TripEntity trip){
        var startLocationDto = LocationHelpers.toLocationDto(trip.getStartLocation());
        var endLocationDto = LocationHelpers.toLocationDto(trip.getEndLocation());
        var directionsDto = DirectionsHelpers.toDirectionsDto(trip.getDirections());
        return new TripDto(trip.getId(), trip.getName(), startLocationDto, endLocationDto, directionsDto);
    }

}
