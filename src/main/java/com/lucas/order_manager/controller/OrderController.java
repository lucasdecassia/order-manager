package com.lucas.order_manager.controller;

import com.lucas.order_manager.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public String processOrder(@RequestParam double amount,
                               @RequestParam String clientId,
                               @RequestParam String clientEmail,
                               @RequestParam (required = false) String discountCode){
        service.processOrder(amount, clientId, clientEmail, discountCode);
        return "Order processed successfully";
    }

    @GetMapping({"/{orderId}"})
    public double getOrderAmount(@PathVariable Long orderId){
        return service.getOrderAmount(orderId);
    }
}
