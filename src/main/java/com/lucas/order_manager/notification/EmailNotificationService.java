package com.lucas.order_manager.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements EmailSender{
    @Override
    public void sendNotification(String email, String message) {
        System.out.println("sending email to " + email + ": " + message);
    }
}
