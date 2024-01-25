package com.sanskar.homeworkspring3.vehicledto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDTO {
    String message;
    HttpStatus statusCode;
}
