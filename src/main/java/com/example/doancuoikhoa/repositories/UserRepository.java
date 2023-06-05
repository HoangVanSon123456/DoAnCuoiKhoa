package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);

    User findUserById(int id);

    List<User> findAllBy();

    User findUserByRefreshToken(String refreshToken);

    @Query(value = "SELECT u FROM User u WHERE u.userPosition = 'TEACHER'")
    List<User> findAllByPositionTeacher(String userPosition);

    @Query(value = "SELECT u FROM User u WHERE u.userPosition = 'STUDENT'")
    List<User> findAllByPositionStruden(String userPosition);

    @Query(value = "SELECT u FROM User u WHERE CONCAT(u.name, ' ', u.id, ' ') LIKE %?1%")
    List<User> search(String keyword);

    List<User> findAllByIdIn(List<Integer> userId);
}
