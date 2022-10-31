package com.maotterson.currentroutes.directions;

import com.maotterson.currentroutes.locations.LocationEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MockDirectionsServiceImpl implements IDirectionsService {
    public Directions getDirections(LocationEntity startLocation, LocationEntity endLocation) throws IOException {
        var startPlaceId = startLocation.getPlaceId();
        var endPlaceId = endLocation.getPlaceId();
        var description = "VIA 1-90";
        var duration = 22f;
        return new Directions(duration, description);
    }
}
