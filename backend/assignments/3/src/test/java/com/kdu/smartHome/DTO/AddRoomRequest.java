package com.kdu.smartHome.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddRoomRequest {
    @JsonProperty("room_name")
    private String roomName;
}
