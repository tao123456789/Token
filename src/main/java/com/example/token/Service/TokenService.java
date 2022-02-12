package com.example.token.Service;

public interface TokenService {
    String getToken(int id,String name);

    Integer checkToken(String token);
    void insertToken(String token);
}
