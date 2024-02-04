package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.AddInventoryRequestDTO;
import com.kdu.smarthome.dto.response.AddInventoryResponseDTO;
import com.kdu.smarthome.dto.response.GetAllInventoryResponseDTO;
import com.kdu.smarthome.services.DeviceInventoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@Slf4j
public class InventoryController {

    DeviceInventoryService inventoryService;

    public InventoryController(DeviceInventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    /**
     *
     * @param addInventoryRequestDTO
     * @return AddInventoryResponseDTO
     */
    @PostMapping("")
    public ResponseEntity<AddInventoryResponseDTO> addInventory(@Valid @RequestBody AddInventoryRequestDTO addInventoryRequestDTO){

        log.info("POST: api/v1/inventory");
        log.debug(addInventoryRequestDTO.toString());

        AddInventoryResponseDTO addInventoryResponseDTO = inventoryService.addInventory(addInventoryRequestDTO);

        return new ResponseEntity<>(addInventoryResponseDTO, HttpStatus.OK);
    }


    /**
     *
     * @return GetAllInventoryResponseDTO
     */
    @GetMapping("")
    public ResponseEntity<GetAllInventoryResponseDTO> getAllInventory(){

        log.info("GET: api/v1/inventory");

        GetAllInventoryResponseDTO getAllInventoryResponseDTO = inventoryService.getAllInventory();
        return new ResponseEntity<>(getAllInventoryResponseDTO, HttpStatus.OK);
    }
}
