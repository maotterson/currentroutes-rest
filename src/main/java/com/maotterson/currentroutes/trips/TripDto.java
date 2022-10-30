package com.maotterson.currentroutes.trips;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maotterson.currentroutes.directions.DirectionsDto;
import com.maotterson.currentroutes.locations.LocationDto;
import lombok.Data;

@Data
public class TripDto {
    private final Long id;
    private final String name;
    @JsonProperty("start_location")
    private final LocationDto startLocation;
    @JsonProperty("end_location")
    private final LocationDto endLocation;
    @JsonProperty("directions")
    private final DirectionsDto directions;
}
