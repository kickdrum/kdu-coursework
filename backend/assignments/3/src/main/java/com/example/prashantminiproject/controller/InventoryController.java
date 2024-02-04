package com.example.prashantminiproject.controller;

import com.example.prashantminiproject.model.Device;
import com.example.prashantminiproject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getInventory() {
        List<Device> inventory = inventoryService.getInventory();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Inventory retrieved successfully");
        response.put("inventory", inventory);
        response.put("httpStatus", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addItemToInventory(@RequestBody Device device) {

        return ResponseEntity.ok(Map.of("message", "Device added to inventory successfully"));
    }

}
