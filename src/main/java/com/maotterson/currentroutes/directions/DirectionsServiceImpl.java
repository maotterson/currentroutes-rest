package com.maotterson.currentroutes.directions;

import com.maotterson.currentroutes.locations.LocationEntity;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DirectionsServiceImpl implements IDirectionsService {
    private final String GOOGLE_DIRECTIONS_API = "https://maps.googleapis.com/maps/api/directions/json";
    private final String GOOGLE_API_KEY = "";

    public Directions getDirections(LocationEntity startLocation, LocationEntity endLocation) throws IOException {
        var startPlaceId = startLocation.getPlaceId();
        var endPlaceId = endLocation.getPlaceId();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(GOOGLE_DIRECTIONS_API + "?origin=" + startPlaceId + "&destination=" + endPlaceId + "&departure_time=now&key=" + GOOGLE_API_KEY)
                .method("GET", body)
                .build();
        Response response = client.newCall(request).execute();
        return mapToDirections(response);
    }

    private Directions mapToDirections(Response response){
        return new Directions(10f, "description");
    }
}
