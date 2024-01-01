package com.example.prepodov_net.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class JwtUtils {
    private static final String SECRET_KEY = "ITSJUSTASECRETKEYWITHONETASKANDALITTLEWATERANDFUCASDDSAADSDSASDDA"; // Замени на свой секретный ключ

    public static String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 86400000); // Токен действителен 24 часа

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS512)
                .compact();
    }
}
