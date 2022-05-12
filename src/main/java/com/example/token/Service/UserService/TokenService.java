package com.example.token.Service.UserService;

public interface TokenService {
    String createToken(int id,String name);

    Integer checkToken(String token);
    void insertToken(String token);
}
