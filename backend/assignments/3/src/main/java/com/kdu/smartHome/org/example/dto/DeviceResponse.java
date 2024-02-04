package org.example.dto;

import lombok.*;
import org.example.entity.Device;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceResponse {
    private String message;
    private Device device;

    private HttpStatus httpStatus;
}
