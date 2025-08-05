package com.lucas.order_manager.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_email")
    private String clientEmail;

    @Column(name = "final_amount")
    private double finalAmount;

    public Order(Double amount, String clientId, String clientEmail) {
        validade(amount);
        this.orderId = orderId;
        this.amount = amount;
        this.clientId = clientId;
        this.clientEmail = clientEmail;
    }

    public void validade(Double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.amount, amount) == 0 &&
                Double.compare(order.finalAmount, finalAmount) == 0 &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(clientId, order.clientId) &&
                Objects.equals(clientEmail, order.clientEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, amount, clientId, clientEmail, finalAmount);
    }
}
