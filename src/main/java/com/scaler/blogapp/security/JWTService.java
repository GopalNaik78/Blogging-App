package com.scaler.blogapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    // TODO : Move the key separate .property file(not in git)
    private static final String JWT_KEY = "gvsahjdkjasdn76tsyudhsad68hbdhfb674sadhj";
    private Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public String createJWT(Long userId) {
        return JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(new Date())
//                .withExpiresAt() //TODO : setup and expire parameter
                .sign(algorithm);
    }

    public Long retriveUserId(String jwtString) {
        var decodedJWT = JWT.decode(jwtString);
        var UserId = Long.valueOf(decodedJWT.getSubject());
        return UserId;
    }



}
