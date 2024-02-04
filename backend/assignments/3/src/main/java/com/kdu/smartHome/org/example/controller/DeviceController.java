package org.example.controller;

import org.example.dto.DeviceRequest;
import org.example.dto.DeviceResponse;
import org.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class DeviceController {

    private final DeviceService  deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/api/v1/device/add")
    public ResponseEntity<DeviceResponse> addDevice(@RequestBody DeviceRequest deviceRequest){

        DeviceResponse deviceResponse = deviceService.addDevice(deviceRequest);
        return new ResponseEntity<>(deviceResponse,HttpStatus.OK);
    }
}