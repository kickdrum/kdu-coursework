package com.kdu.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    String message;
    String description;
    int httpStatus;

    public ErrorDTO(String message, int httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
