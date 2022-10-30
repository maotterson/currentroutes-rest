package com.maotterson.currentroutes.directions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DirectionsDto {
    @JsonProperty("duration_in_traffic")
    private final float durationInTraffic;
}