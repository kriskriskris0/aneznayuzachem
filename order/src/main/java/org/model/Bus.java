package org.model;
import org.entities.RouteEntity;

import javax.persistence.Column;

public class Bus {

    private Long id;
    private String name;

    private RouteEntity routeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RouteEntity getRouteId() {
        return routeId;
    }
    public void setRouteId(RouteEntity routeId) {
        this.routeId = routeId;
    }
}

