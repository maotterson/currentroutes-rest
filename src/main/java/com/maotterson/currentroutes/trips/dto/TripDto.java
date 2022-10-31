package com.maotterson.currentroutes.trips.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maotterson.currentroutes.directions.DirectionsDto;
import com.maotterson.currentroutes.locations.LocationDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class TripDto {
    private final Long id;
    private final String name;
    @JsonProperty("start_location")
    private final LocationDto startLocation;
    @JsonProperty("end_location")
    private final LocationDto endLocation;
    @JsonProperty("directions")
    @Nullable
    private final DirectionsDto directions;
}
