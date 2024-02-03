package com.kdu.smartHome.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class InventoryRequest {

    @JsonProperty("kickston_id")
    private String kickstonId;

    @JsonProperty("device_username")
    private String deviceUsername;

    @JsonProperty("device_password")
    private String devicePassword;

    @JsonProperty("manufacture_date_time")
    //"String" since LocalDateTime was not serializable without extra pom dependency
    //Convert accordingly at the controller
    private String manufactureDateTime;

    @JsonProperty("manufacture_factory_place")
    private String manufactureFactoryPlace;

}
