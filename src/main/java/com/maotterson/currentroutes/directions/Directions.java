package com.maotterson.currentroutes.directions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Directions {
    @JsonProperty("duration_in_traffic")
    private float durationInTraffic;

    public Directions(float durationInTraffic) {
        this.durationInTraffic = durationInTraffic;
    }

    public float getDurationInTraffic() {
        return durationInTraffic;
    }

    public void setDurationInTraffic(float durationInTraffic) {
        this.durationInTraffic = durationInTraffic;
    }
}
