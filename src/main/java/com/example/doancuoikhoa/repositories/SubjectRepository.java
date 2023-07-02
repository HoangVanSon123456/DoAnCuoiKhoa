package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Subject;
import com.example.doancuoikhoa.entities.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findSubjectById(int id);

    List<Subject> findAllBy();
}
