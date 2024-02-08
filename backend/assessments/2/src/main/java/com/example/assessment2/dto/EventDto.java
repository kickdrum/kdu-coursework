package com.example.assessment2.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDto {
    private int eid;

    private String name;

    private String date;

    private String venue;

    private int tickets;
}
