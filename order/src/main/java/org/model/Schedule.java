package org.model;

import org.entities.RouteEntity;

import java.sql.Time;

public class Schedule {

    private Long id;
    private BusStopEntity busStopId;
    private RouteEntity routeId;
    private Time time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RouteEntity getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteEntity routeId) {
        this.routeId = routeId;
    }

    public BusStopEntity getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(BusStopEntity busStopId) {
        this.busStopId = busStopId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
