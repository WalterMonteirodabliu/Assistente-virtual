package com.walter.mordomo.service;

import com.walter.mordomo.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification createNotification(Notification notification);
    List<Notification> getAllNotifications();
    Optional<Notification> getNotificationById(Long id);
    Optional<Notification> getNotificationsByTaskId(Long taskId);
    Notification updateNotification(Long id, Notification notificationDetails);
    void deleteNotification(Long id);
}
