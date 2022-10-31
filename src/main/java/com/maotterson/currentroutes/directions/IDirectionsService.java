package com.maotterson.currentroutes.directions;

import com.maotterson.currentroutes.locations.LocationEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IDirectionsService  {
    public Directions getDirections(LocationEntity startLocation, LocationEntity endLocation) throws IOException;
}
