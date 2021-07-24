package com.rccode.service;

import com.rccode.constant.ParkingConstants;
import com.rccode.enumeration.VehicleType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Floor;
import com.rccode.model.ParkingLot;
import com.rccode.model.Slot;
import com.rccode.model.Vehicle;

import static com.rccode.constant.ParkingConstants.INVALID_COMMAND_MESSAGE;

public class VehicleParkingService {

    private SlotCheckService slotCheckService;

    public VehicleParkingService(SlotCheckService slotCheckService) {
        this.slotCheckService = slotCheckService;
    }

    public SlotCheckService getSlotCheckService() {
        return slotCheckService;
    }

    public void parkVehicle(String[] command, ParkingLot parkingLot) {
        if (command.length != 4) {
            throw new ProcessException("Park Vehicle", INVALID_COMMAND_MESSAGE);
        }
        VehicleType vehicleType = VehicleType.valueOf(command[1]);

        Slot availableSlot = slotCheckService.getFreeSlot(parkingLot, vehicleType);

        if (availableSlot == null) {
            System.out.println("OUTPUT: Parking Lot Full");
            return;
        }

        availableSlot.setBooked(true);
        Vehicle vehicle = new Vehicle(command[2], command[3], vehicleType);
        availableSlot.setVehicle(vehicle);

        String ticketId = generateTicketId(parkingLot, availableSlot);
        System.out.println(String.format("OUTPUT: Parked vehicle. Ticket ID: %s", ticketId));
    }

    private String generateTicketId(ParkingLot parkingLot, Slot slot) {
        StringBuilder sb = new StringBuilder();
        sb.append(parkingLot.getId()).append(ParkingConstants.DELIMITER)
                .append(slot.getFloorId()).append(ParkingConstants.DELIMITER)
                .append(slot.getId());
        return sb.toString();
    }

    public void unparkVehicle(String[] command, ParkingLot parkingLot) {
        if (command.length != 2) {
            throw new ProcessException("Unpark Vehicle", INVALID_COMMAND_MESSAGE);
        }
        try {
            String ticketId = command[1];
            int floorIdIndex = ticketId.indexOf(ParkingConstants.DELIMITER);
            int slotIdIndex = ticketId.indexOf(ParkingConstants.DELIMITER, floorIdIndex + 1);

            int floorId = ticketId.charAt(floorIdIndex + 1) - '0';
            int slotId = ticketId.charAt(slotIdIndex + 1) - '0';

            Vehicle vehicle = unparkVehicle(parkingLot, floorId, slotId);
            if (vehicle == null) {
                System.out.println("Invalid Ticket");
            } else {
                System.out.println(String.format("OUTPUT: Unparked vehicle with Registration Number: %s and Color: %s",
                        vehicle.getRegistrationNumber(), vehicle.getColor()));
            }
        } catch (Exception e) {
            System.out.println("Invalid Ticket");
        }
    }

    private Vehicle unparkVehicle(ParkingLot parkingLot, int floorId, int slotId) {
        for (Floor floor : parkingLot.getFloors()) {
            if (floor.getId() == floorId) {
                for (Slot slot : floor.getSlots()) {
                    if (slot.getId() == slotId) {
                        slot.setBooked(false);
                        Vehicle vehicle = slot.getVehicle();
                        slot.setVehicle(null);
                        return vehicle;
                    }
                }
            }
        }
        return null;
    }

}
