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
        Device device = inventoryRepository.findByKickstonIdAndDeviceUsernameAndDevicePassword(kickstonId, deviceUsername, devicePassword);
        return device != null;
    }

    public List<Device> getInventory() {
        return inventoryRepository.findAll();
    }

    public void addItemToInventory(Device device) {
        inventoryRepository.save(device);
    }

}
