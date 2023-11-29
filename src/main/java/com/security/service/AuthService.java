package com.security.service;

import com.security.entity1.UserCredential;
import com.security.repository3.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserCredentialRepository userCredentialRepository;


    @Autowired
    jwtService jwtservice;


    // Register new  User
    public void registerUser(UserCredential userCredential){
        userCredentialRepository.save(userCredential);

    }

    // generate token
    public String GenerateToken(String username){
        return jwtservice.generateToken(username);
    }


    // validate token
    public void ValidateToken(final String token){
        jwtservice.validateToken(token);
    }

}
