// LocationResponse.java
package com.caching.dto;

import lombok.Data;

import java.util.List;

@Data
public class LocationResponse {
    private List<LocationData> data;
}

