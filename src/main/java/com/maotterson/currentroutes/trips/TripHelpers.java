package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.directions.DirectionsHelpers;
import com.maotterson.currentroutes.locations.LocationHelpers;
import com.maotterson.currentroutes.trips.dto.CreateTripDto;
import com.maotterson.currentroutes.trips.dto.TripDto;

public class TripHelpers {
    public static TripDto toTripDto(TripEntity trip){
        var startLocationDto = LocationHelpers.toLocationDto(trip.getStartLocation());
        var endLocationDto = LocationHelpers.toLocationDto(trip.getEndLocation());
        return TripDto.builder()
                .id(trip.getId())
                .name(trip.getName())
                .startLocation(startLocationDto)
                .endLocation(endLocationDto)
                .directions(trip.getDirections() != null ? DirectionsHelpers.toDirectionsDto(trip.getDirections()) : null)
                .build();
    }

}
