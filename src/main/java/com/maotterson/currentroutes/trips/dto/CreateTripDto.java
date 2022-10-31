package com.maotterson.currentroutes.trips.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maotterson.currentroutes.locations.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(NON_NULL)
public class CreateTripDto {
    private String name;
    @JsonProperty("start_location_id")
    private long startLocationId;
    @JsonProperty("end_location_id")
    private long endLocationId;
}
