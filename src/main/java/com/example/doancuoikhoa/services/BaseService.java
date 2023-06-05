package com.example.doancuoikhoa.services;


import com.example.doancuoikhoa.jwt.JwtTokenProvider;
import com.example.doancuoikhoa.model.UserDTO;
import com.example.doancuoikhoa.repositories.StudentClassRepository;
import com.example.doancuoikhoa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected JwtTokenProvider jwtTokenProvider;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    protected StudentClassRepository studentClassRepository;
}
