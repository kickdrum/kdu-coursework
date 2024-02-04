package com.example.prashantminiproject.service;

import com.example.prashantminiproject.model.Device;
import com.example.prashantminiproject.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository=inventoryRepository;
    }

    public boolean validateDeviceInInventory(String kickstonId, String deviceUsername, String devicePassword, String manufactureDateTime, String manufactureFactoryPlace) {
        // Implement logic to validate if the device exists in the inventory
        Device device = inventoryRepository.findByKickstonIdAndDeviceUsernameAndDevicePassword(kickstonId, deviceUsername, devicePassword);
        // Add additional validation logic based on manufactureDateTime and manufactureFactoryPlace if needed
        return device != null;
    }

    public List<Device> getInventory() {
        return inventoryRepository.findAll();
    }

    public void addItemToInventory(Device device) {
        // Validate and handle logic for adding a device to inventory
        // Set other necessary properties
        inventoryRepository.save(device);
    }

    // Implement other inventory-related methods as needed
}
