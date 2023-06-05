package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.NotificationDTO;

import java.util.List;

public interface NotificationService {

    void addNotification(NotificationDTO notificationDTO, String token);

    void updateNotification(NotificationDTO notificationDTO);

    void deleteNotification(Integer id) throws Exception;

    NotificationDTO getNotificationById(Integer id);

    List<NotificationDTO> search(String keyword);
    List<NotificationDTO> getListNotification();
}
