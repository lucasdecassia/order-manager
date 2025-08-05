package com.lucas.order_manager.repository;

import com.lucas.order_manager.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    default double findOrderAmountById(Long orderId){
        return findById(orderId)
                .map(Order:: getFinalAmount)
                .orElse(0.0);
    }
}
