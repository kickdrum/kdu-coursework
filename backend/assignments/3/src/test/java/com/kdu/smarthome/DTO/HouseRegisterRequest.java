package com.kdu.smarthome.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HouseRegisterRequest {
    @JsonProperty("address")
    private String address;

    @JsonProperty("houseName")
    private String houseName;

}
