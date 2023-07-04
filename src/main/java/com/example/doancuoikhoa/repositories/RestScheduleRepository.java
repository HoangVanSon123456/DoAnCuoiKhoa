package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Position;
import com.example.doancuoikhoa.entities.RestSchedule;
import com.example.doancuoikhoa.entities.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestScheduleRepository extends JpaRepository<RestSchedule, Integer> {
    RestSchedule findRestScheduleById(int id);

    List<RestSchedule> findAllBy();

    List<RestSchedule> findAllByUserId(Integer userId);}
