package com.kdu.caching.dto;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GeoCodeResponseDto {
    private double latitude;
    private double longitude;
    private int httpStatus;
}
