package com.maotterson.currentroutes.directions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DirectionsDto {
    @JsonProperty("duration_in_traffic")
    private final Float durationInTraffic;
    @JsonProperty("description")
    private final String description;
}
