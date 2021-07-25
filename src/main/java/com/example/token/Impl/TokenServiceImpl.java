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
    private UserMapper userMapper;//这里会报错，但并不影响

    @Override
    public String getToken(int id,String name) {
        return JWT.create().withAudience(String.valueOf(id)).sign(Algorithm.HMAC256(name));
    }

    @Override
    public int checkToken(String token){
        return userMapper.checkToken(token);
    }

    @Override
    public void insertToken(String token){
        userMapper.insertToken(token);
    }
}
