package com.tli.orders.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemRequest {
    String name;
    Double price;
    Double quantity;
}
