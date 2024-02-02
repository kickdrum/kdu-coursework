//package com.example.assesment2.filter;
//
//import com.example.assesment2.entity.User;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//
//    private static final String SECRET_KEY = "your-secret-key"; // Change this with a secure key
//    private static final long VALIDITY_IN_MILLISECONDS = 3600000; // 1 hour
//
//    public String generateToken(Authentication authentication) {
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + VALIDITY_IN_MILLISECONDS);
//
//        return Jwts.builder()
//                .setSubject(authentication.getName())
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = new User("dummy", "dummy", new ArrayList<>()); // Implement a user details service
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
//}
