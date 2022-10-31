package com.maotterson.currentroutes.locations.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationDto {
    private final Long id;
    private final String name;
    @JsonProperty("place_id")
    private final String placeId;
}
