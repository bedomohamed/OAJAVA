package com.tli.orders.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    int id;
    String status;
    List<OrderLineItemResponse> lineItems = new ArrayList<OrderLineItemResponse>();
    public void addLineItem(OrderLineItemResponse orderLineItemResponse) {
        this.lineItems.add(orderLineItemResponse);
    }
}

