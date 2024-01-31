package com.example.prashantjdbc.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AllEntitiesDTO {
    private ShiftTypeDto shiftTypeDto;
    private ShiftDto shiftDto;
    private UserDto userDto;
    private ShiftUserDto shiftUserDto;
}
