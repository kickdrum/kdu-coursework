package com.example.prashantminiproject.service;

import com.example.prashantminiproject.model.Device;
import com.example.prashantminiproject.repository.DeviceRepository;
import com.example.prashantminiproject.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    private final InventoryService inventoryService;
    @Autowired
    public DeviceService(DeviceRepository deviceRepository, InventoryService inventoryService){
        this.deviceRepository=deviceRepository;
        this.inventoryService=inventoryService;
    }

    public Device registerDevice(String kickstonId, String deviceUsername, String devicePassword, String manufactureDateTime, String manufactureFactoryPlace) {
        // Validate and handle logic for registering a new device
        // Check against the inventory and register only if it matches
        if (inventoryService.validateDeviceInInventory(kickstonId, deviceUsername, devicePassword, manufactureDateTime, manufactureFactoryPlace)) {
            Device device = new Device();
            device.setKickstonId(kickstonId);
            device.setDeviceUsername(deviceUsername);
            device.setDevicePassword(devicePassword);
            device.setManufactureDateTime(manufactureDateTime);
            device.setManufactureFactoryPlace(manufactureFactoryPlace);
            // Set other necessary properties
            return deviceRepository.save(device);
        }
        return null; // or throw an exception indicating the device is not in the inventory
    }

    // Implement other device-related methods as needed
}
