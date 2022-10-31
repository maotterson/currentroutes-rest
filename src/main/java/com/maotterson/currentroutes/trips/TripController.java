package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.directions.DirectionsHelpers;
import com.maotterson.currentroutes.locations.LocationHelpers;
import com.maotterson.currentroutes.trips.dto.CreateTripDto;
import com.maotterson.currentroutes.trips.dto.EditTripDto;
import com.maotterson.currentroutes.trips.dto.TripDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

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
        var trips = tripService.getAllTripsAndDirections();
        var tripDtoCollection = trips.stream()
                .map(trip -> {
                    return TripHelpers.toTripDto(trip);
                })
                .toList();
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("trips",tripDtoCollection))
                        .message("Trips retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<TripResponse> createTrip(@RequestBody CreateTripDto createTripDto){
        var created = tripService.createTrip(createTripDto);
        if(!created){
            return sendErrorResponse(TripAction.CREATE_TRIP);
        }
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message("Trip created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @DeleteMapping(path = "{tripId}")
    public ResponseEntity<TripResponse> deleteTrip(@PathVariable("tripId") Long tripId){
        var tripToDelete = tripService.getTripById(tripId);
        var deleted = tripService.deleteTripById(tripId);
        if(!deleted){
            return sendErrorResponse(TripAction.DELETE_TRIP);
        }
        var tripDto = TripHelpers.toTripDto(tripToDelete);
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("trip",tripDto))
                        .message("Trip deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PutMapping(path = "{tripId}")
    public ResponseEntity<TripResponse> editTrip(@PathVariable("tripId") Long tripId, @RequestBody EditTripDto editTripDto){
        var edited = tripService.editTripById(tripId, editTripDto);
        if(!edited){
            return sendErrorResponse(TripAction.EDIT_TRIP);
        }
        var editedTrip = tripService.getTripById(tripId);
        var editedTripDto = TripHelpers.toTripDto(editedTrip);
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("trip",editedTripDto))
                        .message("Trip edited")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }



    private ResponseEntity<TripResponse> sendErrorResponse(TripAction typeOfAction){
        String actionMessage = "";
        switch(typeOfAction){
            case EDIT_TRIP -> actionMessage = "Error editing trip.";
            case CREATE_TRIP -> actionMessage = "Error creating trip.";
            case DELETE_TRIP -> actionMessage = "Error deleting trip.";
        }
        return ResponseEntity.ok(
                TripResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message(actionMessage)
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build()
        );
    }

}
