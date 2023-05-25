package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    Notification findNotificationById(int id);

    List<Notification> findAllBy();
}
