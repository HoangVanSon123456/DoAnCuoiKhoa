package com.example.doancuoikhoa.services;


import com.example.doancuoikhoa.entities.Position;
import com.example.doancuoikhoa.entities.Subject;
import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.exceptions.NotFoundException;
import com.example.doancuoikhoa.model.*;
import com.example.doancuoikhoa.response.UserResponse;
import com.example.doancuoikhoa.utils.PasswordGenerator;
import com.example.doancuoikhoa.utils.RoleEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Log4j2
public class UserService extends BaseService implements UserDetailsService {

    public ResponseEntity<?> add(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(PasswordGenerator.encrytePassword(userDTO.getPassword()));
        user.setEnabled(true);
        user.setUserRole(RoleEnum.MEMBER.getRoleName());
        user.setUserPosition(RoleEnum.STUDENT.getRoleName());
        userRepository.save(user);
        return ResponseEntity.ok("Success");
    }

    public ResponseEntity<?> checkUserAuthen(UserDTO userDTO) {
        User user = userRepository.findUserByEmail(userDTO.getEmail());
        if (Objects.isNull(user)) {
            throw new NotFoundException("Email not found");
        }
        if (!user.getEnabled()){
            throw new NotFoundException("Account is not active. Click link in email to active account!");
        }
        //authentication username and password
        String accessToken = authenticationVerify(userDTO.getEmail(), userDTO.getPassword());
        //generate refreshtoken
        String refreshToken = PasswordGenerator.stringRandomGenerator();

        user.setRefreshToken(refreshToken);
        user.setAccessToken(accessToken);
        userRepository.save(user);
        return ResponseEntity.ok(new UserResponse(accessToken, refreshToken));
    }

    public ResponseEntity<?> genNewAccessToken(String refreshToken){
        User tokenInfo = userRepository.findUserByRefreshToken(refreshToken);
        if (Objects.isNull(tokenInfo)){
            throw new NotFoundException("Refresh Token Expired!");
        }
        String accessToken = authenticationVerify(tokenInfo.getEmail(), tokenInfo.getPassword());
        return ResponseEntity.ok(new UserResponse(accessToken, refreshToken));
    }

    public ResponseEntity<?> logout(String token){
        Integer userId = getUserToken(token);
        if(userId != null) {
            User user = userRepository.findUserById(userId);
            user.setRefreshToken("");
            userRepository.save(user);
        }
        return ResponseEntity.ok("Logout Success!");
    }

    public Integer getUserToken(String token) {
        return jwtTokenProvider.getUserIdFromJWT(token);
    }


    public UserDTO getUser(int id, String token) {
        User user = userRepository.getOne(id);
        if (Objects.isNull(user)) {
            throw new NotFoundException("Email not found");
        }
        UserDTO userDTO = new UserDTO();
        if (user.getId() == getUserToken((token))) {
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setName(user.getName());
            userDTO.setUseName(user.getUseName());
            userDTO.setAddress(user.getAddress());
            userDTO.setPhone(user.getPhone());
        }else {
            throw new NotFoundException("Email not found");
        }
        return userDTO;
    }

    public ResponseEntity<?> getOneUser(int id) {
        User user = userRepository.getOne(id);
        if (Objects.isNull(user)) {
            throw new NotFoundException("Email not found");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        return ResponseEntity.ok(userDTO);
    }

    public String authenticationVerify(String username, String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return accessToken;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        CustomUserDetails customUserDetails = new CustomUserDetails(user, authorities);
        return customUserDetails;
    }

    public UserDetails loadUserById(int id) {
        User user = userRepository.findUserById(id);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        return new CustomUserDetails(user, authorities);
    }

    public void addUserTeacher(UserDTO userDTO) {
        User user = new User();
        user.setCode(userDTO.getCode());
        user.setName(userDTO.getName());
        user.setUseName(userDTO.getUseName());
        user.setAddress(userDTO.getAddress());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setPassword(PasswordGenerator.encrytePassword(userDTO.getPassword()));
        user.setPhone(userDTO.getPhone());
        user.setEnabled(true);
        user.setUserRole(RoleEnum.ADMIN.getRoleName());
        user.setUserPosition(userDTO.getUserPosition());
        user.setCode(userDTO.getCode());
        user.setDepict(userDTO.getDepict());
        user.setUserPosition(RoleEnum.TEACHER.getRoleName());
        Position position = new Position();
        position.setId(userDTO.getPositionId());
        user.setPosition(position);
        Subject subject = new Subject();
        subject.setId(userDTO.getSubjectId());
        user.setSubject(subject);
        userRepository.save(user);
    }

    public void addUserStudent(UserDTO userDTO) {
        User user = new User();
        user.setCode(userDTO.getCode());
        user.setName(userDTO.getName());
        user.setUseName(userDTO.getUseName());
        user.setAddress(userDTO.getAddress());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setPassword(PasswordGenerator.encrytePassword(userDTO.getPassword()));
        user.setPhone(userDTO.getPhone());
        user.setEnabled(true);
        user.setUserRole(RoleEnum.MEMBER.getRoleName());
        user.setUserPosition(RoleEnum.STUDENT.getRoleName());
        Position position = new Position();
        position.setId(userDTO.getPositionId());
        user.setPosition(position);
        Subject subject = new Subject();
        subject.setId(userDTO.getSubjectId());
        user.setSubject(subject);
        userRepository.save(user);
    }

    public void updateUserTeacher(UserDTO userDTO) throws Exception {
        User user = userRepository.findUserById(userDTO.getId());
        if(user != null) {
            user.setName(userDTO.getName());
            user.setUseName(userDTO.getUseName());
            user.setAddress(userDTO.getAddress());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setUserPosition(userDTO.getUserPosition());
            user.setCode(userDTO.getCode());
            user.setDepict(userDTO.getDepict());
            Position position = new Position();
            position.setId(userDTO.getPositionId());
            position.setName(userDTO.getPositionName());
            user.setPosition(position);
            Subject subject = new Subject();
            subject.setId(userDTO.getSubjectId());
            subject.setName(userDTO.getSubjectName());
            user.setSubject(subject);
        }
        userRepository.save(user);
    }

    public void updateUserStudent(UserDTO userDTO) throws Exception {
        User user = userRepository.findUserById(userDTO.getId());
        if(user != null) {
            user.setCode((userDTO.getCode()));
            user.setName(userDTO.getName());
            user.setUseName(userDTO.getUseName());
            user.setAddress(userDTO.getAddress());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setUserPosition(userDTO.getUserPosition());
        }
        userRepository.save(user);
    }


    public void deleteUser(Integer id) throws Exception {
        User user = userRepository.findUserById(id);
        if(user != null) {
            userRepository.delete(user);
        } else {
            throw new Exception("Không tìm thấy người dùng");
        }
    }


    public UserDTO getUserById(Integer id) {
        User user = userRepository.findUserById(id);
        if(user != null) {
            return convertToDTO(user);
        }
        return null;
    }

    public UserDTO getTeacherById(Integer id) {
        User user = userRepository.findUserById(id);
        if(user != null) {
            return convertTeacherToDTO(user);
        }
        return null;
    }

    private UserDTO convertTeacherToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUseName(user.getUseName());
        userDTO.setAddress(user.getAddress());
        userDTO.setAge(user.getAge());
        userDTO.setGender(user.getGender());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setUserPosition(user.getUserPosition());
        userDTO.setUserRole(user.getUserRole());
        userDTO.setCode(user.getCode());
        userDTO.setDepict(user.getDepict());
        return userDTO;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUseName(user.getUseName());
        userDTO.setAddress(user.getAddress());
        userDTO.setAge(user.getAge());
        userDTO.setGender(user.getGender());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setUserPosition(user.getUserPosition());
        userDTO.setUserRole(user.getUserRole());
        userDTO.setCode(user.getCode());
        userDTO.setDepict(user.getDepict());
        userDTO.setPositionId(user.getPosition().getId());
        userDTO.setPositionName(user.getPosition().getName());
        userDTO.setSubjectId(user.getSubject().getId());
        userDTO.setSubjectName(user.getSubject().getName());
        return userDTO;
    }


    public List<UserDTO> getListUser() {
        List<User> users = userRepository.findAllBy();
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user -> {
            userDTOs.add(convertToDTO(user));
        });
        return userDTOs;
    }

    public List<UserDTO> searchUser(String keyword) {
        List<User> users = userRepository.search(keyword);
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user -> {
            userDTOs.add(convertToDTO(user));
        });
        return userDTOs;
    }

    public List<UserDTO> getListTeacher() {
        List<User> users = userRepository.findAllByPositionTeacher(RoleEnum.TEACHER.getRoleName());
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user -> {
            userDTOs.add(convertTeacherToDTO(user));
        });
        return userDTOs;
    }

    public List<UserDTO> getListUserTeacher() {
        List<User> users = userRepository.findAllByPositionTeacher(RoleEnum.TEACHER.getRoleName());
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user -> {
            userDTOs.add(convertToDTO(user));
        });
        return userDTOs;
    }

    public List<UserDTO> getListUserStudent() {
        List<User> users = userRepository.findAllByPositionStruden(RoleEnum.STUDENT.getRoleName());
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user -> {
            userDTOs.add(convertToDTO(user));
        });
        return userDTOs;
    }

    public void changePassword(UserDTO userDTO) {
        User user = userRepository.getOne(userDTO.getId());
        if (user != null && PasswordGenerator.checkHashStrings(userDTO.getPassword(), user.getPassword())) {
            user.setPassword(PasswordGenerator.encrytePassword(userDTO.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new DataIntegrityViolationException("wrong password");
        }
    }

}
