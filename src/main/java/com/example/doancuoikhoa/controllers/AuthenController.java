package com.example.doancuoikhoa.controllers;


import com.example.doancuoikhoa.model.UserDTO;
import com.example.doancuoikhoa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api")
public class AuthenController {

    @Autowired
    private UserService userService;

    @PostMapping("/authen/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @PostMapping("/authen/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){
        return userService.checkUserAuthen(userDTO);
    }

    @GetMapping("/authen/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("refreshToken") String refreshToken){
        return null;
//        return userService.genNewAccessToken(refreshToken);
    }

    @GetMapping("/authen/logout")
    public ResponseEntity<?> logout(@PathVariable(name = "id") Integer userId,@RequestHeader("refreshToken") String refreshToken){
        return userService.logout(userId,refreshToken);
    }

    @GetMapping("/member/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable("id") Integer id){
        return userService.getOneUser(id);
    }

}
