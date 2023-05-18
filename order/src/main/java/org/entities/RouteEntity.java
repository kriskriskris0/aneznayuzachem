package org.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name="route")
public class RouteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private double name;

    public Long getId(){
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

