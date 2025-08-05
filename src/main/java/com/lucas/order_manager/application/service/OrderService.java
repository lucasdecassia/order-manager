package com.lucas.order_manager.application.service;

public interface OrderService {
    void processOrder(double amount, String clientId, String clientEmail, String discountCode);
    double getOrderAmount(Long orderId);
}
