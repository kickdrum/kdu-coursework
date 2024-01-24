package asish.kdu.Spring_Exercise_3.controller;

import asish.kdu.Spring_Exercise_3.dtos.VehicleDto;
import asish.kdu.Spring_Exercise_3.models.Vehicle;
import asish.kdu.Spring_Exercise_3.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller for the Entire App
 */
@RestController
@RequestMapping("/kdu")
public class AppController {
    private final VehicleService service;

    @Autowired
    public AppController(VehicleService service) {
        this.service = service;
    }

    @GetMapping("/vehicle/{name}")
    public Vehicle findByName(@PathVariable String name) {
        return service.getVehicleRequest(name);
    }

    @PostMapping("/vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createVehicle(@RequestBody VehicleDto vehicleDto) {
        service.addVehicleRequest(vehicleDto);
        return ResponseEntity.ok("Vehicle added to Database");
    }

    @PutMapping(value = "/vehicle/{name}")
    public ResponseEntity<String> updateVehicle(@PathVariable String name, @RequestBody VehicleDto vehicleDto) {
        service.updateVehicleRequest(name, vehicleDto);
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    @DeleteMapping(value = "/vehicle/{name}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String name) {
        service.deleteVehicleRequest(name);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    @GetMapping("/vehicle/mostexpensive")
    public Vehicle mostExpensive() {
        return service.getMostExpensive();
    }

    @GetMapping("/vehicle/leastexpensive")
    public Vehicle leastExpensive() {
        return service.getLeastExpensive();
    }
}