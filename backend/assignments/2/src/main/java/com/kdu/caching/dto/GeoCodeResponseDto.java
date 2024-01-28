package com.kdu.caching.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO class for returning response of successful GeoCode call
 */
@Data
@AllArgsConstructor
public class GeoCodeResponseDto {
    private double latitude;
    private double longitude;
    private int httpStatus;
}
