package com.lucas.order_manager.domain.discount;

public class TwentyPercentDiscount implements DiscountStrategy {
    @Override
    public double applyPercentDiscount(Double amount) {
        return amount * 0.20;
    }
}
