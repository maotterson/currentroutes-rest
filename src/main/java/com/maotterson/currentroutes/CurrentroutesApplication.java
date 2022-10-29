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
    CommandLineRunner migrateData(TripRepository tripRepository, LocationRepository locationRepository){
        return args -> {
            locationRepository.save(new LocationEntity("My house"));
            locationRepository.save(new LocationEntity("The store"));
            var location1 = locationRepository.findById(1L).orElseThrow();
            var location2 = locationRepository.findById(2L).orElseThrow();
            tripRepository.save(new TripEntity(location1, location2));
        };
    }
}
