package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);

    User findUserById(int id);

    List<User> findAllBy();

    User findUserByRefreshToken(String refreshToken);

    @Query("delete from User b where b.refreshToken=:refreshToken")
    void deleteRefreshToken(String refreshToken);
}
