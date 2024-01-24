package asish.kdu.Spring_Exercise_3.services;

import asish.kdu.Spring_Exercise_3.dtos.VehicleDto;
import asish.kdu.Spring_Exercise_3.dtos.mappers.VehicleMapper;
import asish.kdu.Spring_Exercise_3.models.Vehicle;
import asish.kdu.Spring_Exercise_3.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

/**
 * Component annotation ensures Bean of VehicleService is
 * created.
 */
@Service
public class VehicleService implements FactoryService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle getVehicleRequest(String name) {
        return vehicleRepository.findVehicle(name);
    }

    @Override
    public void addVehicleRequest(VehicleDto vDto) {
        Vehicle vehicle = VehicleMapper.dtoToEntity(vDto);
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public void updateVehicleRequest(String name, VehicleDto vDto) {
        Vehicle vehicle = VehicleMapper.dtoToEntity(vDto);
        vehicleRepository.updateVehicle(name, vehicle);
    }

    @Override
    public void deleteVehicleRequest(String name) {
        vehicleRepository.deleteVehicle(name);
    }

    @Override
    public Vehicle getMostExpensive() {
        return vehicleRepository.allVehicles().stream().max(Comparator.comparingDouble(Vehicle::price)).orElse(null);
    }

    @Override
    public Vehicle getLeastExpensive() {
        return vehicleRepository.allVehicles().stream().min(Comparator.comparingDouble(Vehicle::price)).orElse(null);
    }
}