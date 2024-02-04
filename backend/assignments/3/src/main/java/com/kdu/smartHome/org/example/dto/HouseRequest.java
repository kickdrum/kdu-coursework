package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseRequest {
    @JsonProperty("address")
    private String address;

    @JsonProperty("house_name")
    private String houseName;

}
