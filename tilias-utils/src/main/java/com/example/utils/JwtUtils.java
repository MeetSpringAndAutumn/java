package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * 生成新类/接口/枚举
 *
 * @Author: shanzhengshuai
 * @Description: Jwt
 * @Date: 2024/10/28
 */

public class JwtUtils {
    public static SecretKey signKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static Long expire=7200000000L;
    public static String generateJwt(Map<String,Object> claims)
    {
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }
    public static Claims parseJwt(String jwt)
    {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
