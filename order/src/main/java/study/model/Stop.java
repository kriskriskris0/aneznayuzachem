package study.model;


public class Stop {
    private Long id;
    private String address;
    private Route route;

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

    public Route getRoute() { return route; }

    public void setRoute(Route route) {
        this.route = route;
    }
}
