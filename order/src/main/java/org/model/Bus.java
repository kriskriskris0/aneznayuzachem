package org.model;
import javax.persistence.Column;

public class Bus {

    private Long id;
    private String name;

    private Long routeId;

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

    public Long getRouteId() {
        return routeId;
    }
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}

