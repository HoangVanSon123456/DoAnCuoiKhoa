package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.UserDTO;
import com.example.doancuoikhoa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin/user/create")
    private UserDTO createUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return userDTO;
    }
    @GetMapping("/member/user")
    private List<UserDTO> getAll() {
        return userService.getListUser();
    }

    @DeleteMapping(value = "/admin/user/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) throws Exception {
        userService.deleteUser(id);
    }

    @PutMapping(value = "/admin/user/update/{id}")
    public void updateUser(@PathVariable(name = "id") Integer id,@RequestBody UserDTO userDTO) throws Exception {

        userService.updateUser(userDTO);
    }

    @GetMapping(value = "/member/user/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Integer id) {
        return userService.getUserById(id);
    }

}