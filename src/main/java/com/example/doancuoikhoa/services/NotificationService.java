package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.NotificationDTO;

import java.util.List;

public interface NotificationService {

    void addNotification(NotificationDTO notificationDTO);

    void updateNotification(NotificationDTO notificationDTO);

    void deleteNotification(Integer id) throws Exception;

    NotificationDTO getNotificationById(Integer id);


    List<NotificationDTO> getListNotification();
}
