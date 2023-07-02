package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Position;
import com.example.doancuoikhoa.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position , Integer> {

    Position findPositionById(int id);

    List<Position> findAllBy();
}
