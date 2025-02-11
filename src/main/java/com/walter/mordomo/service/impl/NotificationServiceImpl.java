package com.walter.mordomo.service.impl;

import com.walter.mordomo.model.Notification;
import com.walter.mordomo.repository.NotificationRepository;
import com.walter.mordomo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Optional<Notification> getNotificationsByTaskId(Long taskId) {
        return notificationRepository.findByTaskId(taskId);
    }

    @Override
    public Notification updateNotification(Long id, Notification notificationDetails) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setMessage(notificationDetails.getMessage());
            return notificationRepository.save(notification);
        }).orElseThrow(() -> new RuntimeException("Notificação não encontrada"));
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
