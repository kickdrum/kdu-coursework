package com.caching.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReverseGeocodingResponse {
    private List<ReverseGeocodingData> data;
}