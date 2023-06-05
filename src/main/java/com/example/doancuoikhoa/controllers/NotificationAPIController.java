package com.example.doancuoikhoa.controllers;


import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.NotificationDTO;
import com.example.doancuoikhoa.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")

public class NotificationAPIController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/admin/notification")
    private List<NotificationDTO> getAll() {
        return notificationService.getListNotification();
    }

    @GetMapping("/admin/notification/{id}")
    private NotificationDTO getNotifiationById(@PathVariable(name = "id") Integer id) {
        return notificationService.getNotificationById(id);
    }
    @DeleteMapping(value = "/admin/notification/delete/{id}")
    private void deleteNotification(@PathVariable(name = "id") Integer id) throws Exception {
        notificationService.deleteNotification(id);
    }

    @PostMapping(value = "/admin/notification/add")
    private NotificationDTO addNotification(@RequestBody NotificationDTO notificationDTO, @RequestHeader("token") String token) {
        notificationService.addNotification(notificationDTO, token);
        return notificationDTO;
    }

    @PutMapping(value = "/admin/notification/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody NotificationDTO notificationDTO) {
        notificationService.updateNotification(notificationDTO);
    }

    @GetMapping(value = "/admin/notification/search/{keyword}")
    public  List<NotificationDTO> search(@PathVariable(name = "keyword") String keyword) {
        return notificationService.search(keyword);
    }
}
