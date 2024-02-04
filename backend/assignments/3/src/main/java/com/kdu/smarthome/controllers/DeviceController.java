package com.kdu.smarthome.controllers;


import com.kdu.smarthome.dto.request.AddDeviceRequestDTO;
import com.kdu.smarthome.dto.request.MoveDeviceRequestDTO;
import com.kdu.smarthome.dto.request.RegisterDeviceRequestDTO;
import com.kdu.smarthome.dto.response.AddDeviceResponseDTO;
import com.kdu.smarthome.dto.response.RegisterDeviceResponseDTO;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.InvalidDeviceCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import com.kdu.smarthome.services.DeviceService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/device")
@Slf4j
public class DeviceController {

    DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    /**
     *
     * @param registerDeviceRequestDTO
     * @return RegisterDeviceResponseDTO
     * @throws InvalidCredentialsException
     * @throws ResourceNotFoundException
     * @throws InvalidDeviceCredentialsException
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterDeviceResponseDTO> registerDevice(@Valid @RequestBody RegisterDeviceRequestDTO registerDeviceRequestDTO) throws InvalidCredentialsException, ResourceNotFoundException, InvalidDeviceCredentialsException {

        RegisterDeviceResponseDTO registerDeviceResponseDTO = deviceService.registerDevice(registerDeviceRequestDTO);

        return new ResponseEntity<>(registerDeviceResponseDTO, HttpStatus.OK);
    }

    /**
     *
     * @param addDeviceRequestDTO
     * @return AddDeviceResponseDTO
     * @throws InvalidCredentialsException
     * @throws InvalidDeviceCredentialsException
     */
    @PostMapping("/add")
    public ResponseEntity<AddDeviceResponseDTO> addDeviceInHouse(@Valid @RequestBody AddDeviceRequestDTO addDeviceRequestDTO) throws InvalidCredentialsException, InvalidDeviceCredentialsException {

        log.info("POST: /api/v1/device/add");
        log.debug("Request data: " + addDeviceRequestDTO);

        AddDeviceResponseDTO addDeviceResponseDTO = deviceService.addDevice(addDeviceRequestDTO);
        return new ResponseEntity<>(addDeviceResponseDTO, HttpStatus.OK);
    }


    @PostMapping("/move")
    public ResponseEntity<String> moveDevice(@Valid @RequestBody MoveDeviceRequestDTO moveDeviceRequestDTO) throws InvalidDeviceCredentialsException {
        log.info("POST: /api/v1/device/move");
        log.debug("Request data: " + moveDeviceRequestDTO);

        deviceService.moveDevice(moveDeviceRequestDTO);
        return new ResponseEntity<>("Device moved successfully!!", HttpStatus.OK);
    }
}
