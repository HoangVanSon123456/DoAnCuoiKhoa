package com.example.doancuoikhoa.services.impl;


import com.example.doancuoikhoa.entities.Course;
import com.example.doancuoikhoa.entities.Notification;
import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.jwt.JwtTokenProvider;
import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.NotificationDTO;
import com.example.doancuoikhoa.repositories.NotificationRepository;
import com.example.doancuoikhoa.repositories.UserRepository;
import com.example.doancuoikhoa.services.NotificationService;
import com.example.doancuoikhoa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    public void addNotification(NotificationDTO notificationDTO , String token) {
        Notification notification = new Notification();
        notification.setTitle(notificationDTO.getTitle());
        notification.setContent(notificationDTO.getContent());
        notification.setFiles(notificationDTO.getFiles());
        int userId = userService.getUserToken(token);
        User user = userRepository.findUserById(userId);
        notification.setUser(user);
        notificationRepository.save(notification);
    }


    @Override
    public void updateNotification(NotificationDTO notificationDTO) {
        Notification notification = notificationRepository.findNotificationById(notificationDTO.getId());
        if(notification != null){
            notification.setTitle(notificationDTO.getTitle());
            notification.setContent(notificationDTO.getContent());
            notification.setFiles(notificationDTO.getFiles());
        }
        notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Integer id) throws Exception {
        Notification notification = notificationRepository.findNotificationById(id);
        if(notification != null) {
            notificationRepository.delete(notification);
        }else {
            throw new Exception("Không tìm thấy người dùng");
        }
    }

    @Override
    public NotificationDTO getNotificationById(Integer id) {
        Notification notification = notificationRepository.findNotificationById(id);
        if(notification != null) {
           return converToDTO(notification);
        }
        return null;
    }

    @Override
    public List<NotificationDTO> search(String keyword) {
        List<Notification> notifications = notificationRepository.search(keyword);
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        notifications.forEach(notification -> {
            notificationDTOS.add(converToDTO(notification));
        });
        return notificationDTOS;
    }

    @Override
    public List<NotificationDTO> getListNotification() {
        List<Notification> notifications = notificationRepository.findAllBy();
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        notifications.forEach(notification -> {
            notificationDTOS.add(converToDTO(notification));
        });
        return notificationDTOS;
    }

    private NotificationDTO converToDTO(Notification notifications) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notifications.getId());
        notificationDTO.setTitle(notifications.getTitle());
        notificationDTO.setContent(notifications.getContent());
        notificationDTO.setFiles(notifications.getFiles());
        if (notifications.getUser() != null) {
            notificationDTO.setUserId(notifications.getUser().getId());
            notificationDTO.setUserName(notifications.getUser().getName());
        }
        return notificationDTO;
    }
}
