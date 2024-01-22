package org.handson;

import org.handson.service.VehicleService;

public class Main {
    /**
     * Main method to initialize VehicleService, add vehicles, and find the highest price.
     *
     * @param  args	array of command-line arguments
     * @return     	void
     */
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        for(int i = 0; i <10; i++)
        {
            vehicleService.addVehicle();
        }

        vehicleService.highestPrice();
    }
}