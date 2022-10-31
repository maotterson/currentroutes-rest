package com.maotterson.currentroutes.directions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Directions {
    @JsonProperty("duration_in_traffic")
    private Float durationInTraffic;
    @JsonProperty("description")
    private String description;

    public Directions(Float durationInTraffic, String description) {
        this.durationInTraffic = durationInTraffic;
        this.description = description;
    }

    public float getDurationInTraffic() {
        return durationInTraffic;
    }

    public void setDurationInTraffic(float durationInTraffic) {
        this.durationInTraffic = durationInTraffic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
