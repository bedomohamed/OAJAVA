package com.tli.orders.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "ORDER_LINE_ITEMS")
public class OrderLineItem {
    @Id
//    @GeneratedValue
    @Column(name = "number")
    private int number;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "modified_Date")
    private LocalDate modifiedDate;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "modified_by")
    private int modifiedBy;
}
