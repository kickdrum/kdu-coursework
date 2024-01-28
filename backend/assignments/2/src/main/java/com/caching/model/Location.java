package com.caching.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Data
@AllArgsConstructor
public class Location {
    @JsonTypeId
    @Generated

    private String address;
    private Double latitude;
    private Double longitude;

}
