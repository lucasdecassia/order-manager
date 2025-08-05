package com.lucas.order_manager.domain.discount;

public class TenPercentDiscount implements DiscountStrategy {
    @Override
    public double applyPercentDiscount(Double amount) {
        return amount * 0.10;
    }
}
