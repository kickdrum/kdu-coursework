package com.kdu.smarthome.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserToHouseRequest {
    private String username;
}
