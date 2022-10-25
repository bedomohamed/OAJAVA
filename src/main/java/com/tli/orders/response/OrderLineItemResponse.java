package com.tli.orders.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemResponse {
    private int number;
    private int orderId;
    private String name;
    private double price;
    private double quantity;
}
