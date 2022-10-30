package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.directions.DirectionsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final DirectionsService directionsService;

    public TripService(TripRepository tripRepository, DirectionsService directionsService) {
        this.tripRepository = tripRepository;
        this.directionsService = directionsService;
    }

    public Collection<TripEntity> getAllTrips(){
        return tripRepository.findAll();
    }

    public Collection<TripEntity> getAllTripsAndDirections() {
        var trips = getAllTrips();
        trips.forEach(trip -> {
            var startLocation = trip.getStartLocation();
            var endLocation = trip.getEndLocation();
            try {
                trip.setDirections(directionsService.getDirections(startLocation, endLocation));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return trips;
    }
}
