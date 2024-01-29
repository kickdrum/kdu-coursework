package com.example.assignment2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReverseGeoCodingResponseDTO {
    private String address;
}
