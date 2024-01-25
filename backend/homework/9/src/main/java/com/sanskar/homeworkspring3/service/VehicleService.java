package com.sanskar.homeworkspring3.service;

import com.sanskar.homeworkspring3.model.vehicle;
import com.sanskar.homeworkspring3.vehicledto.vehicledto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    vehicledto createVehicle(vehicledto vehicle);
    vehicle getVehicleById(int id);
    List<vehicle> getAllVehicles();
    void updateVehicle(int id, vehicledto vehicle);
    void deleteVehicle(int id);
    vehicle mostExpensive();
    vehicle leastExpensive();
}
