package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.jwt.JwtTokenProvider;
import com.example.doancuoikhoa.model.ResponseDTO;
import com.example.doancuoikhoa.model.UserDTO;
import com.example.doancuoikhoa.services.UserService;
import com.example.doancuoikhoa.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin/userTeacher/create")
    private UserDTO createTeacherUser(@RequestBody UserDTO userDTO) throws IOException {
        userService.addUserTeacher(userDTO);
        return userDTO;
    }
    @PostMapping("/admin/userStudent/create")
    private UserDTO createStudentUser(@RequestBody UserDTO userDTO) throws IOException {
        userService.addUserStudent(userDTO);
        return userDTO;
    }

    @GetMapping("/admin/user")
    private List<UserDTO> getAll() {
        return userService.getListUser();
    }

    @GetMapping("/admin/teacher_class")
    private List<UserDTO> getAllListTeacher() {
        return userService.getListTeacher();
    }

    @GetMapping("/admin/teacher")
    private ResponseDTO<UserDTO> getAllTeacher() {
        ResponseDTO<UserDTO> responseDTO = new ResponseDTO<UserDTO>();
        responseDTO.setData(userService.getListUserTeacher());
        return responseDTO;
    }

    @GetMapping("/admin/student")
    private List<UserDTO> getAllStudent() {
        return userService.getListUserStudent();
    }

    @DeleteMapping(value = "/admin/user/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) throws Exception {
        userService.deleteUser(id);
    }

    @PutMapping(value = "/admin/userTeacher/update/{id}")
    public void updateUserTeacher(@PathVariable(name = "id") Integer id,@RequestBody UserDTO userDTO) throws Exception {
        userService.updateUserTeacher(userDTO);
    }

    @PutMapping(value = "/admin/userStudent/update/{id}")
    public void updateUserStudent(@PathVariable(name = "id") Integer id,@RequestBody UserDTO userDTO) throws Exception {
        userService.updateUserStudent(userDTO);
    }

    @GetMapping(value = "/admin/user/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Integer id) {
        return userService.getUserById(id);
    }


    @GetMapping(value = "/admin/user/search/{keyword}")
    public  List<UserDTO> search(@PathVariable(name = "keyword") String keyword) {
        return userService.searchUser(keyword);
    }

    @PutMapping(value = "/admin/change-password")
    public void changePassword(@RequestBody UserDTO userDTO , @RequestHeader("token") String token) {
        Integer userId = userService.getUserToken(token);
        userDTO.setId(userId);
        userService.changePassword(userDTO);
        System.out.println("thanh cong");
    }

}
