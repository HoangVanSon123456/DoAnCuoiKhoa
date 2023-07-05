package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Academic;
import com.example.doancuoikhoa.entities.Position;
import com.example.doancuoikhoa.entities.RestSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicRepository extends JpaRepository<Academic, Integer> {
    Academic findAcademicById(int id);

    List<Academic> findAllBy();

    @Query(value = "SELECT a FROM Academic a inner join  User u on u.id = a.user.id WHERE CONCAT(u.code,'') LIKE %?1%")
    List<Academic> search(String keyword);

}
