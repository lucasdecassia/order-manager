package com.lucas.order_manager.domain.discount;

public interface DiscountStrategy {
    double applyPercentDiscount(Double amount);
}
