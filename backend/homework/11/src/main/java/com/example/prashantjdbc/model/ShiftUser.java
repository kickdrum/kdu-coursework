package com.example.prashantjdbc.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ShiftUser {
    private UUID id;
    private UUID shiftId;
    private UUID userId;
    private String createdBy;
    private String updatedBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UUID tenantId;

}