package com.example.doancuoikhoa.controllers;


import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.jwt.JwtTokenProvider;
import com.example.doancuoikhoa.model.UserDTO;
import com.example.doancuoikhoa.services.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class AuthenController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/authen/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @PostMapping("/authen/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        return userService.checkUserAuthen(userDTO);
    }

    @GetMapping("/authen/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("refreshToken") String refreshToken) {
        return userService.genNewAccessToken(refreshToken);
    }

    @GetMapping("/authen/logout")
    public ResponseEntity<?> logout( @RequestHeader("token") String token) {
        return userService.logout(token);
    }

//    @GetMapping("/member/profile/{id}")
//    public ResponseEntity<?> getProfile(@PathVariable("id") Integer id) {
//        return userService.getOneUser(id);
//    }

    @GetMapping("/admin/profile/{id}")
    public ResponseEntity<?> getProfileA(@PathVariable("id") Integer id) {
        return userService.getOneUser(id);
    }

    @GetMapping("/authen/getToken")
    public Integer getUserToken(@RequestHeader("token") String token) {
        return userService.getUserToken(token);
    }

    @GetMapping("/authen/getUser/{id}")
    public UserDTO getProfileA(@PathVariable("id") Integer id, @RequestHeader("token") String token) {
        return userService.getUser(id, token);
    }
}
