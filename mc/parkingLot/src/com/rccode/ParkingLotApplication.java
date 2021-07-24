package com.rccode;

import com.rccode.service.MasterService;
import com.rccode.service.SlotCheckService;
import com.rccode.service.VehicleParkingService;

public class ParkingLotApplication {

    public static void main(String[] args) {
	// write your code here
        SlotCheckService slotCheckService = new SlotCheckService();
        VehicleParkingService vehicleParkingService = new VehicleParkingService(slotCheckService);
        MasterService masterService = new MasterService(vehicleParkingService);
        masterService.controller();
    }
}
