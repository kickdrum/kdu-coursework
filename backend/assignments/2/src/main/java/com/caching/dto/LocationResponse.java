// LocationResponse.java
package com.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
//@AllArgsConstructor
public class LocationResponse {
    private List<LocationData> data;
}

