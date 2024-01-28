package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO class for returning errors
 */
@Data
@AllArgsConstructor
public class ErrorDto {
    private String message;
    private int code;
}
