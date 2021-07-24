package com.rccode.model;

import java.util.List;

public class ParkingLot {

    private String id;
    private List<Floor> floors;

    public ParkingLot(String id, List<Floor> floors) {
        this.id = id;
        this.floors = floors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
