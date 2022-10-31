package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.directions.DirectionsServiceImpl;
import com.maotterson.currentroutes.directions.IDirectionsService;
import com.maotterson.currentroutes.directions.MockDirectionsServiceImpl;
import com.maotterson.currentroutes.locations.LocationService;
import com.maotterson.currentroutes.trips.dto.CreateTripDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final LocationService locationService;
    private final IDirectionsService directionsService;

    // change mock service to api service to integrate google maps api
    public TripService(TripRepository tripRepository, LocationService locationService, MockDirectionsServiceImpl directionsService) {
        this.tripRepository = tripRepository;
        this.directionsService = directionsService;
        this.locationService = locationService;
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

    public Boolean createTrip(CreateTripDto createTripDto){
        try{
            var startLocation = locationService.getLocationById(createTripDto.getStartLocationId());
            var endLocation = locationService.getLocationById(createTripDto.getEndLocationId());
            var trip = new TripEntity(createTripDto.getName(), startLocation, endLocation);
            tripRepository.save(trip);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public Boolean deleteTripById(Long id){
        tripRepository.deleteById(id);
        return true;
    }
}
