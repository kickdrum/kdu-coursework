package com.example.prashantminiproject.service;

import com.example.prashantminiproject.model.Device;
import com.example.prashantminiproject.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final InventoryService inventoryService;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, InventoryService inventoryService){
        this.deviceRepository = deviceRepository;
        this.inventoryService = inventoryService;
    }

    public Device registerDevice(String kickstonId, String deviceUsername, String devicePassword, String manufactureDateTime, String manufactureFactoryPlace) {
        if (inventoryService.validateDeviceInInventory(kickstonId, deviceUsername, devicePassword, manufactureDateTime, manufactureFactoryPlace)) {
            Device device = new Device();
            device.setKickstonId(kickstonId);
            device.setDeviceUsername(deviceUsername);
            device.setDevicePassword(devicePassword);
            return deviceRepository.save(device);
        }
        return null;
    }
}
