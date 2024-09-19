package com.BSP.StudentApis.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import static jdk.jfr.internal.EventWriterKey.getKey;

@Service
public class JWTService {
    private String secertKey="";

    public JWTService(){
        try {
            KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacSHA256");
            SecretKey sK=keyGenerator.generateKey();
            secertKey= Base64.getEncoder().encodeToString(sK.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }
    public String generateToken(String username) {
        Map<String,Object> claims=new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*30))
                .and()
                .signWith(getKey())
                .compact();

    }

    public Key getKey(){
        byte[] keyBytes= Decoders.BASE64.decode(secertKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
