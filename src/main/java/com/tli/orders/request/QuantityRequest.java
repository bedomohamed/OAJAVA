package com.tli.orders.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityRequest {
    int orderId;
    int itemId;
    double quantity;
}
