package kdu.backend.security.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

    String username;
    String jwtToken;
}
