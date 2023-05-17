package org.example;

import javax.persistence.*;
import java.io.Serializable;
@Entity(name="bus")
public class BusEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId(){
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

    @Column(name = "route_ID", nullable = false)
    private Long routeID;

    public Long getRouteID() {
        return routeID;
    }

    public void setRouteID(Long clientId) {
        this.routeID = routeID;
    }
}

