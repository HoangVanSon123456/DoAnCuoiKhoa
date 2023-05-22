package com.example.doancuoikhoa.services;


import com.example.doancuoikhoa.entities.Token;
import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.exceptions.NotFoundException;
import com.example.doancuoikhoa.model.CustomUserDetails;
import com.example.doancuoikhoa.model.TokenInfo;
import com.example.doancuoikhoa.model.UserDTO;
import com.example.doancuoikhoa.response.UserResponse;
import com.example.doancuoikhoa.utils.PasswordGenerator;
import com.example.doancuoikhoa.utils.RoleEnum;
import lombok.extern.log4j.Log4j2;
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
        user.setUsePass(PasswordGenerator.encrytePassword(userDTO.getPassword()));
        user.setEnabled(true);
        user.setUserRole(RoleEnum.MEMBER.getRoleName());
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

        Token token = tokenRepository.findByUserId(user.getId());
        if (Objects.isNull(token)) {
            token = new Token();
            token.setUserId(user.getId());
        }
        token.setRefreshToken(refreshToken);
        token.setAccessToken(accessToken);
        tokenRepository.save(token);
        return ResponseEntity.ok(new UserResponse(accessToken, refreshToken));
    }

//    public ResponseEntity<?> genNewAccessToken(String refreshToken){
//        TokenInfo tokenInfo = tokenRepository.findTokenById(); //thay luu vao db
//        if (Objects.isNull(tokenInfo)){
//            throw new NotFoundException("Refresh Token Expired!");
//        }
//        String accessToken = authenticationVerify(tokenInfo.getEmail(), tokenInfo.getPassword());
//        return ResponseEntity.ok(new UserResponse(accessToken, refreshToken));
//    }

    public ResponseEntity<?> logout(Integer userId){
        Token token = tokenRepository.findByUserId(userId);
        if (token != null) {
            tokenRepository.delete(token);
        }
        User user = userRepository.findUserById(userId);
//        if(user != null) {
//            tokenRepository.delete(refreshToken);
//        }
//        cacheManagerService.deleteToken(refreshToken); //xoa trong
        return ResponseEntity.ok("Logout Success!");
    }

    public ResponseEntity<?> getOneUser(int id) {
        User user = userRepository.getOne(id);
        if (user.getUserRole().equalsIgnoreCase(RoleEnum.ADMIN.getRoleName())) {

        }
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
}
