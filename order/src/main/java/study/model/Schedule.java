package study.model;

import study.entities.BusEntity;
import study.entities.StopEntity;
import study.entities.RouteEntity;

import java.sql.Time;

public class Schedule {

    private Long id;
    private BusEntity busId;
    private StopEntity stopId;
    private RouteEntity routeId;
    private Time time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  BusEntity getBusId(){ return busId; }

    public void setBusId(BusEntity busId) { this.busId = busId; }

    public RouteEntity getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteEntity routeId) {
        this.routeId = routeId;
    }

    public StopEntity getStopId() {
        return stopId;
    }

    public void setStopId(StopEntity busStopId) {
        this.stopId = busStopId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
