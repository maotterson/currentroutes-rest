package com.maotterson.currentroutes.directions;


import com.maotterson.currentroutes.directions.dto.DirectionsDto;

public class DirectionsHelpers {
    public static DirectionsDto toDirectionsDto(Directions directions){
        return new DirectionsDto(directions.getDurationInTraffic(), directions.getDescription());
    }
}
