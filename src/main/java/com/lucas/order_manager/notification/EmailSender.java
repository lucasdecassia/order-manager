package com.lucas.order_manager.notification;

public interface EmailSender {
    void sendNotification(String email, String message);
}
