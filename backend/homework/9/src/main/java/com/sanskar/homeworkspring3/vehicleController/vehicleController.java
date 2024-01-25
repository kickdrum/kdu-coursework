package com.sanskar.homeworkspring3.vehicleController;

import com.sanskar.homeworkspring3.exception.MyCustomException;
import com.sanskar.homeworkspring3.model.vehicle;
import com.sanskar.homeworkspring3.service.VehicleService;
import com.sanskar.homeworkspring3.vehicledto.ErrorDTO;
import com.sanskar.homeworkspring3.vehicledto.vehicledto;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * vehicleController consist of GET, POST, PUT AND DELETE request
 * using URL and URL parameters
 * Response Entity
 */
@Slf4j
@RestController
@AllArgsConstructor
public class vehicleController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(vehicleController.class);

    private VehicleService vehicleService;

//    @PostMapping
//    public ResponseEntity<String> createUser(@RequestBody vehicledto vehicle){
//        vehicleService.createVehicle(vehicle);
//        return new ResponseEntity<>("Created Successfully", HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody vehicledto vehicle){
        try{
            vehicleService.createVehicle(vehicle);
            log.info("Success User creation");
            return new ResponseEntity<>("created user successfully", HttpStatus.CREATED);
        }catch(MyCustomException e){
            log.warn("Index out of bounds for user creation");
            return new ResponseEntity<>("IndexoutofBOunds :(", HttpStatus.CREATED);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<vehicle> getVehicleById(@PathVariable("id") int vehicleId){
        try{
            vehicle vehicle = vehicleService.getVehicleById(vehicleId);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }catch(IndexOutOfBoundsException e){
            throw new MyCustomException("Index provided is out of bounds");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id,@RequestBody vehicledto updatedVehicle) throws MyCustomException  {
        try {
            vehicleService.updateVehicle(id, updatedVehicle);
            return new ResponseEntity<>("Vehicle updated successfully", HttpStatus.CREATED);
        }catch (IndexOutOfBoundsException e) {
            ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            log.warn("\nException handled by Custom Exception\n{}", errorDTO);
            throw new MyCustomException("Vehicle not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
