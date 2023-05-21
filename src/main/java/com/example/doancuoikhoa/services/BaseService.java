package com.example.doancuoikhoa.services;


import com.example.doancuoikhoa.jwt.JwtTokenProvider;
import com.example.doancuoikhoa.repositories.TokenRepository;
import com.example.doancuoikhoa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected TokenRepository tokenRepository;

    @Autowired
    protected JwtTokenProvider jwtTokenProvider;

    @Autowired
    protected AuthenticationManager authenticationManager;

}
