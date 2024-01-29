package com.example.assignment2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReverseGeoCodingRequestDTO {
    private double latitude;
    private double longitude;
}
