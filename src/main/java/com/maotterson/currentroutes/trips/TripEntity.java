package com.maotterson.currentroutes.trips;

import com.maotterson.currentroutes.locations.LocationEntity;

import javax.persistence.*;

@Entity
@Table
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "start_location_id")
    private LocationEntity startLocation;
    @ManyToOne
    @JoinColumn(name = "end_location_id")
    private LocationEntity endLocation;
    public TripEntity(LocationEntity startLocation, LocationEntity endLocation) {
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
}
