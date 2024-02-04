package org.example.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceRequest {
    private String houseId;
    private String roomId;
    private String kickstonId;

}
