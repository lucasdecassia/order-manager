package com.lucas.order_manager.application.service;

import com.lucas.order_manager.domain.discount.DiscountStrategy;
import com.lucas.order_manager.domain.model.Order;
import com.lucas.order_manager.domain.discount.TenPercentDiscount;
import com.lucas.order_manager.domain.discount.TwentyPercentDiscount;
import com.lucas.order_manager.notification.EmailNotificationService;
import com.lucas.order_manager.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl  implements OrderService{

    private final OrderRepository repository;
    private final EmailNotificationService emailNotification;
    private final Map<String, DiscountStrategy> discountStrategies;

    public OrderServiceImpl(OrderRepository repository, EmailNotificationService notificationService) {
        this.repository = repository;
        this.emailNotification = notificationService;
        this.discountStrategies = new HashMap<>();
        this.discountStrategies.put("SAVE10", new TenPercentDiscount());
        this.discountStrategies.put("SAVE20", new TwentyPercentDiscount());
    }

    @Override
    public void processOrder(double amount, String clientId, String clientEmail, String discountCode) {
        Order order = new Order(amount, clientId, clientEmail);

        double discount = 0;
        if (discountCode != null && discountStrategies.containsKey(discountCode)) {
            discount = discountStrategies.get(discountCode).applyPercentDiscount(amount);
        }
        double finalAmount = order.getAmount() - discount;
        order.setFinalAmount(finalAmount);

        repository.save(order);
        emailNotification.sendNotification(clientEmail, "Your Order has been processed" + order.getOrderId() + "with" +
                "final amount " + finalAmount);
    }

    @Override
    public double getOrderAmount(Long orderId) {
        return repository.findOrderAmountById(orderId);
    }
}
