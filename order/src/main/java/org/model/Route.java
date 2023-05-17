package org.model;

import javax.persistence.Column;

public class Route {

    private Long id;
    private double name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getName() {
        return name;
    }

    public void setName(double name) {
        this.name = name;
    }
}
