package com.kdu.smarthome.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeviceRegisterRequest {
    @JsonProperty("kickstonId")
    private String kickstonId;

    @JsonProperty("deviceUsername")
    private String deviceUsername;

    @JsonProperty("devicePassword")
    private String devicePassword;

}
