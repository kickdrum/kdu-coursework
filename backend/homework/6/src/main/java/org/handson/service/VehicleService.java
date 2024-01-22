package org.handson.service;

import jakarta.annotation.PostConstruct;
import org.handson.*;
import org.handson.components.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Configuration
public class VehicleService {
    private
    List<Vehicle> vehicleList = new ArrayList<>();
   private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfig.class);
   /**
    * Adds a vehicle to the vehicle list.
    *
    */
   @PostConstruct
   public void addVehicle()
    {
        vehicleList.add(context.getBean(Vehicle.class));

    }

    /**
     * Calculate and log the vehicle with the highest price in the vehicle list.
     */
    public void highestPrice()
    {
        
        int maximumPrice = 0;
        Vehicle v = null;
        for(var vehicle : vehicleList)
        {
            if(maximumPrice<vehicle.getPrice())
            {  maximumPrice=vehicle.getPrice();
            v = vehicle;}
            MyLogger.customLogger(vehicle.toString(),"DEBUG");
        }
        if(v!=null)
            MyLogger.customLogger("The maximum price belongs to : "+v.toString(),"DEBUG");
    
        else
            MyLogger.customLogger("Error: object null","ERROR");
        }




}
