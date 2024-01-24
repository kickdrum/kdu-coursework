package asish.kdu.Spring_Exercise_3.services;

import asish.kdu.Spring_Exercise_3.dtos.VehicleDto;
import asish.kdu.Spring_Exercise_3.models.Vehicle;

public interface FactoryService {
     Vehicle getVehicleRequest(String name);
     void addVehicleRequest(VehicleDto vDto);
     void updateVehicleRequest(String name, VehicleDto vDto);
     void deleteVehicleRequest(String name);
     Vehicle getMostExpensive();
     Vehicle getLeastExpensive();
}
