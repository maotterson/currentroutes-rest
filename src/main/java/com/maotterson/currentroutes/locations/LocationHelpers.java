package com.maotterson.currentroutes.locations;

import com.maotterson.currentroutes.locations.dto.LocationDto;

public class LocationHelpers {
    public static LocationDto toLocationDto(LocationEntity location){
        return new LocationDto(location.getId(), location.getName(), location.getPlaceId());
    }
}
