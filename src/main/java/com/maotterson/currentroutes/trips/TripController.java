package com.maotterson.currentroutes.trips;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(trips)
                        .message("Trips retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
