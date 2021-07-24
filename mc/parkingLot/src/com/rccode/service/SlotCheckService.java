package com.rccode.service;

import com.rccode.constant.ParkingConstants;
import com.rccode.enumeration.VehicleType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Floor;
import com.rccode.model.ParkingLot;
import com.rccode.model.Slot;

import java.util.LinkedList;
import java.util.List;

public class SlotCheckService {

    public Slot getFreeSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (Floor floor : parkingLot.getFloors()) {
            for (Slot slot: floor.getSlots()) {
                if (slot.getType().equals(vehicleType) && !slot.isBooked()) {
                    return slot;
                }
            }
        }
        return null;
    }

    public List<Slot> getFreeSlots(ParkingLot parkingLot, int floorId, VehicleType vehicleType) {
        List<Slot> freeSlots = new LinkedList<>();
        Floor floor =getFloorById(parkingLot, floorId);
        for (Slot slot : floor.getSlots()) {
            if (slot.getType().equals(vehicleType) && !slot.isBooked()) {
                freeSlots.add(slot);
            }
        }
        return freeSlots;
    }

    public Floor getFloorById(ParkingLot parkingLot, int floorId) {
        for (Floor floor : parkingLot.getFloors()) {
            if (floor.getId() == floorId) {
                return floor;
            }
        }
        throw new ProcessException("Get Floor By Id : Invalid floor ID", ParkingConstants.INVALID_COMMAND_MESSAGE);
    }

}
