package com.rccode.service;

import com.rccode.enumeration.VehicleType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Floor;
import com.rccode.model.ParkingLot;
import com.rccode.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.rccode.constant.ParkingConstants.INVALID_COMMAND_MESSAGE;

public class MasterService {

    private final String EXIT_COMMAND = "exit";

    private ParkingLot parkingLot;

    private VehicleParkingService vehicleParkingService;

    public MasterService(VehicleParkingService vehicleParkingService) {
        this.vehicleParkingService = vehicleParkingService;
    }

    public void controller() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Parking Lot Application Started, please enter command\n");

        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            System.out.println();
            if (command.equals(EXIT_COMMAND)) {
                break;
            }
            processCommand(command);
            System.out.println();
        }

        System.out.println("Terminating Parking Lot Application");
    }

    private void processCommand(String command) {
        try {
            String[] commandArray = command.split("\\s");

            switch (commandArray[0]) {
                case "create_parking_lot" :
                    createParkingLot(commandArray);
                    break;
                case "park_vehicle" :
                    vehicleParkingService.parkVehicle(commandArray, parkingLot);
                    break;
                case "unpark_vehicle" :
                    vehicleParkingService.unparkVehicle(commandArray, parkingLot);
                    break;
                case "display" :
                    System.out.println("Display operation called");
                    break;
                default:
                    System.out.println(INVALID_COMMAND_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(INVALID_COMMAND_MESSAGE);
        }
    }

    private void createParkingLot(String[] command) {
        if (command.length != 4) {
            throw new ProcessException("Create Parking Lot", INVALID_COMMAND_MESSAGE);
        }
        List<Floor> floors = createFloor(Integer.parseInt(command[2]), Integer.parseInt(command[3]));
        parkingLot = new ParkingLot(command[1], floors);
        System.out.println(String.format("OUTPUT\nCreated parking lot with %s floors and %s slots per floor", command[2], command[3]));
    }

    private List<Floor> createFloor(int floorCount, int slotCount) {
        List<Floor> floors = new ArrayList<Floor>();
        for (int i = 0; i < floorCount; i++) {
            List<Slot> slots = createSlots(i + 1, slotCount);
            Floor floor = new Floor(i + 1, slots);
            floors.add(floor);
        }
        return floors;
    }

    private List<Slot> createSlots(int floorId, int slotCount) {
        List<Slot> slots = new ArrayList<Slot>();
        for (int i = 0; i < slotCount; i++) {
            VehicleType type;
            if (i == 0) {
                type = VehicleType.TRUCK;
            } else if (i < 3) {
                type = VehicleType.BIKE;
            } else {
                type = VehicleType.CAR;
            }
            Slot slot = new Slot(i+1, floorId, type, false, null);
            slots.add(slot);
        }
        return slots;
    }

}
