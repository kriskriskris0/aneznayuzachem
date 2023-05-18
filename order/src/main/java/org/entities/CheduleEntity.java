package org.entities;

import org.example.BusStopEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity(name="chedule")
public class CheduleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "busStopId")
    private BusStopEntity busStop;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private RouteEntity route;

    @Column(name = "time")
    private Time time;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RouteEntity getRouteId() { return route; }

    public void setRouteId(RouteEntity route) { this.route = route; }

    public BusStopEntity getBusStopId() { return busStop; }

    public void setBusStopId(BusStopEntity busStop) {
        this.busStop = busStop;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


}
