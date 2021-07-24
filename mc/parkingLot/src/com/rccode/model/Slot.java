package com.rccode.model;

import com.rccode.enumeration.VehicleType;

public class Slot {

    private int id;
    private int floorId;
    private VehicleType type;
    private boolean booked;
    private Vehicle vehicle;

    public Slot(int id, int floorId, VehicleType type, boolean booked, Vehicle vehicle) {
        this.id = id;
        this.floorId = floorId;
        this.type = type;
        this.booked = booked;
        this.vehicle =vehicle;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
