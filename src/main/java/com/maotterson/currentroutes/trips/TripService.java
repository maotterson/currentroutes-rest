package com.maotterson.currentroutes.trips;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Collection<TripEntity> getAllTrips(){
        return tripRepository.findAll();
    }
}
