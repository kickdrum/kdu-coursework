package com.sanskar.homeworkspring3.mapper;

import com.sanskar.homeworkspring3.model.vehicle;
import com.sanskar.homeworkspring3.vehicledto.vehicledto;

/**
 * vehicleMapper class maps vehicledto class type to vehicle and vice-versa
 * Reflecting DTO design
 */
public class vehicleMapper {
        public static vehicledto mapToVehicledto(vehicle vehicle){
            return new vehicledto(vehicle.getName(),vehicle.getPrice());
        }
        public static vehicle mapToVehicle(vehicledto vehicleDto){
            return new vehicle(vehicleDto.getName(), vehicleDto.getPrice());
        }
    }

