package study.model;


public class Stop {
    private Long id;
    private String address;
    private Route routeId;

    public Long getId() {
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

    public Route getRouteId() { return routeId; }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }
}
