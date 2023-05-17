package org.example;

import javax.persistence.*;
import java.io.Serializable;
@Entity(name="busStop")
public class BusStopEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "x")
    private float x;

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Column(name = "y")
    private float y;

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Column(name = "route_ID", nullable = false)
    private Long route_ID;

    public Long getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(Long clientId) {
        this.route_ID = route_ID;
    }
}
