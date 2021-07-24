package com.rccode.model;

import java.util.List;

public class Floor {

    private int id;
    private List<Slot> slots;

    public Floor(int id, List<Slot> slots) {
        this.id = id;
        this.slots = slots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
