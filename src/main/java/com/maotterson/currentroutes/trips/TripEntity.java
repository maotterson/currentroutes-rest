package com.maotterson.currentroutes.trips;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maotterson.currentroutes.directions.Directions;
import com.maotterson.currentroutes.locations.LocationEntity;

import javax.persistence.*;

@Entity
@Table
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "start_location_id")
    @JsonProperty("start_location")
    private LocationEntity startLocation;
    @ManyToOne
    @JoinColumn(name = "end_location_id")
    @JsonProperty("end_location")
    private LocationEntity endLocation;

    @Transient
    private Directions directions;

    public TripEntity(String name, LocationEntity startLocation, LocationEntity endLocation) {
        this.name = name;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }
    public TripEntity() {

    }

    public LocationEntity getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationEntity startLocation) {
        this.startLocation = startLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationEntity getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationEntity endLocation) {
        this.endLocation = endLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }
}
