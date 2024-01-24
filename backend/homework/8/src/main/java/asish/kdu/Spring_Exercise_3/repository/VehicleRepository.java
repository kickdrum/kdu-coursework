package asish.kdu.Spring_Exercise_3.repository;

import asish.kdu.Spring_Exercise_3.models.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VehicleRepository {
    private List<Vehicle> db;
    @PostConstruct
    public void init() {
        this.db = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        db.add(vehicle);
    }

    public void updateVehicle(String name, Vehicle vehicle) {
        for(Vehicle v : db) {
            if(v.name().equals(name)) {
                v.name(vehicle.name());
                v.price(vehicle.price() + vehicle.tyre.price() + vehicle.speaker.price());
            }
        }
    }

    public void deleteVehicle(String name) {
        int index = -1;

        for(int i = 0; i < db.size(); i++) {
            if(Objects.equals(db.get(i).name(), name))
                index = i;
        }

        if(index == -1) return;

        db.remove(index);
    }

    public Vehicle findVehicle(String name) {
        for(Vehicle v : db) {
            if(v.name().equals(name)) return v;
        }

        return null;
    }

    public List<Vehicle> allVehicles() {
        return db;
    }
}
