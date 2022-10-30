package com.maotterson.currentroutes;

import com.maotterson.currentroutes.locations.LocationEntity;
import com.maotterson.currentroutes.locations.LocationRepository;
import com.maotterson.currentroutes.trips.TripEntity;
import com.maotterson.currentroutes.trips.TripRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurrentroutesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrentroutesApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(TripRepository tripRepository, LocationRepository locationRepository){
        return args -> {
            locationRepository.save(new LocationEntity("My house", "ChIJ7fYQtob6MIgRgRLpwIItBxU"));
            locationRepository.save(new LocationEntity("The store", "ChIJTbhI1IXwMIgR6YSqsVRS1cE"));
            locationRepository.save(new LocationEntity("The gym", "ChIJtZl8uoH6MIgRIJlSUVz--lM"));
            locationRepository.save(new LocationEntity("The office", "ChIJnzfZu23wMIgRXsydHOM2tKs"));
            var home = locationRepository.findById(1L).orElseThrow();
            var store = locationRepository.findById(2L).orElseThrow();
            var gym = locationRepository.findById(3L).orElseThrow();
            var office = locationRepository.findById(3L).orElseThrow();
            tripRepository.save(new TripEntity("Trip to store", home, store));
            tripRepository.save(new TripEntity("Going to gym", home, gym));
            tripRepository.save(new TripEntity("Work commute", home, office));
        };
    }
}
