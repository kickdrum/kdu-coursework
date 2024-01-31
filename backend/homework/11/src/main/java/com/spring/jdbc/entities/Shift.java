package com.spring.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift {
    private UUID id;
    private UUID shiftTypeId;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String timeZone;
    private UUID tenantId;
}
