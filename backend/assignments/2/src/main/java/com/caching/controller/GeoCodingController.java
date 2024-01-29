package com.example.assignment2.controller;

import com.example.assignment2.dto.GeoCodingRequestDTO;
import com.example.assignment2.dto.GeoCodingResponseDTO;
import com.example.assignment2.dto.ReverseGeoCodingRequestDTO;
import com.example.assignment2.dto.ReverseGeoCodingResponseDTO;
import com.example.assignment2.service.GeoCodingImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping
public class GeoCodingController {
    private final GeoCodingImp geoCodingService;

    @Autowired
    public GeoCodingController(GeoCodingImp geoCodingService){
        this.geoCodingService = geoCodingService;
    }
    @GetMapping("/geocoding")
    public ResponseEntity<GeoCodingResponseDTO> forwardGeoCoding(@RequestParam("address") String address) {
        log.info(address);
        GeoCodingRequestDTO requestDTO = GeoCodingRequestDTO.builder()
                .address(address)
                .build();
        return ResponseEntity.ok(geoCodingService.getGeoCoding(requestDTO));
    }
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<ReverseGeoCodingResponseDTO> reverseGeoCoding(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude){
        ReverseGeoCodingRequestDTO requestDTO = ReverseGeoCodingRequestDTO.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
        return ResponseEntity.ok(geoCodingService.getReverseGeoCoding(requestDTO));
    }
}
