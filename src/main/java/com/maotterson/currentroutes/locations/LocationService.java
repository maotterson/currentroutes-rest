package com.maotterson.currentroutes.locations;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Collection<LocationEntity> getLocations(){
        return locationRepository.findAll();
    }

    public LocationEntity getLocationById(long id) { return locationRepository.findById(id).orElseThrow(); }
}
