package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token , Integer> {
    Token findTokenById(Integer id);

    Token findByUserId(Integer userId);

}
