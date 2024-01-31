package com.spring.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftUser {
    private UUID id;
    private UUID shiftId;
    private UUID userId;
    private UUID tenantId;
}
