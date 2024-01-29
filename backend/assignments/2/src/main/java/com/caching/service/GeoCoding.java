package com.example.assignment2.service;

import com.example.assignment2.dto.GeoCodingRequestDTO;
import com.example.assignment2.dto.GeoCodingResponseDTO;
import com.example.assignment2.dto.ReverseGeoCodingRequestDTO;
import com.example.assignment2.dto.ReverseGeoCodingResponseDTO;

public interface GeoCoding {
    public GeoCodingResponseDTO getGeoCoding(GeoCodingRequestDTO requestDTO);
    public ReverseGeoCodingResponseDTO getReverseGeoCoding(ReverseGeoCodingRequestDTO requestDTO);
}
