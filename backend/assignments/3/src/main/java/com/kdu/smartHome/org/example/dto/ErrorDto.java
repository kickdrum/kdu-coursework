package org.example.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDto {
    private String message;
    private HttpStatus httpStatus;
}