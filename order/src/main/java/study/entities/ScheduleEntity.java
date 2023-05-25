package study.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity(name="schedule")
public class ScheduleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "busId")
    private BusEntity bus;

    @ManyToOne
    @JoinColumn(name = "stopId")
    private StopEntity stop;

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

    public BusEntity getBusId() { return bus; }

    public void setBusId(BusEntity bus) { this.bus = bus; }

    public RouteEntity getRouteId() { return route; }

    public void setRouteId(RouteEntity route) { this.route = route; }

    public StopEntity getStopId() { return stop; }

    public void setStopId(StopEntity busStop) {
        this.stop = busStop;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
