package com.example.token.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.token.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(int id,String name) {
        return JWT.create().withAudience(String.valueOf(id)).sign(Algorithm.HMAC256(name));
    }
}
