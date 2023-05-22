package org.model;

import org.entities.RouteEntity;

import javax.persistence.Column;

public class BusStop {
    private Long id;
    private String address;
    private RouteEntity routeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RouteEntity getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteEntity routeId) {
        this.routeId = routeId;
    }
}
