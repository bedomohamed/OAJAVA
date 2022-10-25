package com.tli.orders.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tli.orders.request.LineItemRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @JsonProperty("items")
    List<LineItemRequest> items = new ArrayList<LineItemRequest>();

}
