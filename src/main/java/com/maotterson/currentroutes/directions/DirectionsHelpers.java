package com.maotterson.currentroutes.directions;


public class DirectionsHelpers {
    public static DirectionsDto toDirectionsDto(Directions directions){
        return new DirectionsDto(directions.getDurationInTraffic(), directions.getDescription());
    }
}
