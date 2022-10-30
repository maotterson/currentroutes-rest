package com.maotterson.currentroutes.locations;

public class LocationHelpers {
    public static LocationDto toLocationDto(LocationEntity location){
        return new LocationDto(location.getId(), location.getName(), location.getPlaceId());
    }
}
