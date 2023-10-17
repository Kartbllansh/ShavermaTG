package com.shaverma.database.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;


@Entity
@Table(name = "ListOrder")
public class ListOrder extends Order {
    private LocalDateTime endTime;
    private String comment;

    public ListOrder(ActiveOrder activeOrder, LocalDateTime endTime, String comment) {
        super();
        setUser(activeOrder.getUser());
        setTimeOrder(activeOrder.getTimeOrder());
        setPrice(activeOrder.getPrice());
        setDish(activeOrder.getDish());
        this.endTime = endTime;
        this.comment = comment;
    }

    public ListOrder() {
    }
}
