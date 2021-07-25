package com.example.token.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.token.service.TokenService;
import com.example.token.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    private UserMapper userMapper;
    @Override
    public String getToken(int id,String name) {
        return JWT.create().withAudience(String.valueOf(id)).sign(Algorithm.HMAC256(name));
    }

    @Override
    public Integer checkToken(String token){
        return userMapper.checkToken(token);
    }

    @Override
    public void insertToken(String token){
        userMapper.insertToken(token);
    }
}
