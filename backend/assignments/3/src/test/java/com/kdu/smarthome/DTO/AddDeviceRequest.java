package com.kdu.smarthome.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddDeviceRequest {


    private String houseId;

    private String roomId;

    private String kickstonId;


}

