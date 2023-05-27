package study.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name="route")
@SequenceGenerator(name = "id_generator", sequenceName = "route_id_seq", allocationSize = 1)
public class RouteEntity implements Serializable {
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


}

