//package com.floobyte.franchise.service;
//
//import com.floobyte.franchise.exception.ApiRequestException;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.SignatureException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//
//    @Value("${jwt.secret-key}") // Load the secret key from configuration
//    private String secretKey;
//
//    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
//        final Claims claims = extractAllClaims(token); // Fix the method name
//        return claimsResolvers.apply(claims);
//    }
//
//    public String extractUserName(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    private Claims extractAllClaims(String token) {
//        try {
//            return Jwts
//                    .parserBuilder()
//                    .setSigningKey(secretKey.getBytes()) // Use the signing key
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (SignatureException e) {
//            throw new ApiRequestException("Please provide a valid token: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
//        } catch (JwtException e) {
//            throw new ApiRequestException("Token parsing failed: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }
//}