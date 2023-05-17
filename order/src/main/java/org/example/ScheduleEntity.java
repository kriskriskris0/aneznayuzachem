package org.example;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name="schedule")
public class ScheduleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "route_ID", nullable = false)
    private Long routeID;

    public Long getRouteID() {
        return routeID;
    }

    public void setRouteID(Long clientId) {
        this.routeID = routeID;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "bus_ID", nullable = false)
    private Long busID;

    public Long getBusID() {
        return busID;
    }

    public void setBusID(Long busID) {
        this.busID = busID;
    }

    @Column(name = "busstop_ID", nullable = false)
    private Long busstopID;

    public Long getBusstopID() {
        return busstopID;
    }

    public void setBusstopID(Long busstopID) {
        this.busstopID = busstopID;
    }

    @Column(name = "time", nullable = false)
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}

