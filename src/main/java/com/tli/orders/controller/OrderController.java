package com.tli.orders.controller;



import com.tli.orders.entity.Order;
import com.tli.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.tli.orders.request.QuantityRequest;
import com.tli.orders.request.OrderRequest;
import com.tli.orders.response.OrderResponse;
import com.tli.orders.request.RemoveItemRequest;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;
    /*
    * Take a list of orders which at least one line item
    *  PLACE ORDER
    *
    * */
    @PostMapping("/CreateOrder")
    public ResponseEntity<OrderResponse> CreateOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(service.saveOrder(orderRequest), HttpStatus.OK);

    }
    /* VIEW ORDER OPERATION
     */
    @GetMapping("/viewOrder/{id}")
    public ResponseEntity<Order> viewOrders(@PathVariable int id) {
        return new ResponseEntity<>(service.getOrderById(id), HttpStatus.OK);

    }
    @GetMapping("/viewOrder")
    public ResponseEntity<List<Order>> viewAllOrders() {
        ResponseEntity<List<Order>> orderList = new ResponseEntity<>(service.getOrders(),HttpStatus.OK);
        return orderList;
    }

    /*
        CANCEL ORDER OPERATION
    */

    @GetMapping("/cancelOrder/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable int id) {
        return new ResponseEntity<String>(service.deleteOrder(id),HttpStatus.OK);
    }


    /*
        CHANGE QUANTITY OPERATION
    */

    @PostMapping(value = "/update")

    public ResponseEntity<String> update(@RequestBody QuantityRequest orderRequest) {
        if (orderRequest.getQuantity() > 0) {
            return new ResponseEntity<String>(service.updateQuantity(orderRequest.getOrderId(),orderRequest.getItemId(), orderRequest.getQuantity()),HttpStatus.OK);
        }
        return new ResponseEntity<String>("Quantity Has to be more than 1",HttpStatus.BAD_REQUEST);

    }


    /*
        REMOVE LINE ITEM OPERATION
     */
    @DeleteMapping("/removeItem")
    public ResponseEntity<String> removeItem(@RequestBody RemoveItemRequest removeItemRequest) {
        return new ResponseEntity<String>(service.deleteItem(removeItemRequest),HttpStatus.OK);
    }


}
