package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.directions.DirectionsServiceImpl;
import com.maotterson.currentroutes.directions.IDirectionsService;
import com.maotterson.currentroutes.directions.MockDirectionsServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final IDirectionsService directionsService;

    // change mock service to api service to integrate google maps api
    public TripService(TripRepository tripRepository, MockDirectionsServiceImpl directionsService) {
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

    public TripEntity getTripById(Long id){
        return tripRepository.findById(id).orElseThrow();
    }

    public Boolean editTripById(Long id, TripEntity trip){
        tripRepository.save(trip); // may not require id using JPA
        return true;
    }

    public Boolean createTrip(TripEntity trip){
        tripRepository.save(trip);
        return true;
    }

    public Boolean deleteTripById(Long id){
        tripRepository.deleteById(id);
        return true;
    }
}
