package com.kdu.smarthome.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryRequest {

    @JsonProperty("kickstonId")
    private String kickstonId;

    @JsonProperty("deviceUsername")
    private String deviceUsername;

    @JsonProperty("devicePassword")
    private String devicePassword;

    @JsonProperty("manufactureDateTime")
    //"String" since LocalDateTime was not serializable without extra pom dependency
    //Convert accordingly at the controller
    private String manufactureDateTime;

    @JsonProperty("manufactureFactoryPlace")
    private String manufactureFactoryPlace;

}
