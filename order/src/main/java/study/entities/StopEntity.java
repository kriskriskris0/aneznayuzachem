package study.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="stop")
@SequenceGenerator(name = "id_generator", sequenceName = "stop_id_seq", allocationSize = 1)
public class StopEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="routeId")
    private RouteEntity routeId;

    public Long getId(){
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
