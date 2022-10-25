package com.tli.orders.service;
import javax.transaction.Transactional;

import com.tli.orders.repository.LineItemRepository;
import com.tli.orders.repository.OrderRepository;
import com.tli.orders.request.RemoveItemRequest;
import com.tli.orders.response.OrderLineItemResponse;
import com.tli.orders.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tli.orders.entity.Order;

import java.util.ArrayList;
import java.util.List;
import com.tli.orders.entity.OrderLineItem;
import java.time.*;
import com.tli.orders.request.OrderRequest;
import com.tli.orders.request.LineItemRequest;
@Service
@Transactional

public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private LineItemRepository lineItemRepo;

    public OrderResponse saveOrder(OrderRequest orderRequest) {
        // Create Order and insert to Orders table
        Order newOrder = new Order(1,LocalDate.now(), 1, LocalDate.now(), 1);
        newOrder = repository.save(newOrder);

        // insert each item to the item table
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(newOrder.getId());
        List<OrderLineItem> allItems = new ArrayList<>();
        int num = 1;
        for (LineItemRequest item : orderRequest.getItems()) {
            OrderLineItem newLineItem = new OrderLineItem();
            newLineItem.setNumber(num);
            newLineItem.setOrderId(newOrder.getId());
            newLineItem.setName(item.getName());
            newLineItem.setPrice(item.getPrice());
            newLineItem.setQuantity(item.getQuantity());
            OrderLineItemResponse respNewLine = new OrderLineItemResponse();
            respNewLine.setName(item.getName());
            respNewLine.setQuantity(item.getQuantity());
            respNewLine.setPrice(item.getPrice());
            respNewLine.setOrderId(newOrder.getId());
            orderResponse.addLineItem(respNewLine);
            respNewLine.setNumber(num);
            num++;

            newLineItem.setCreatedDate(newOrder.getCreatedDate());
            newLineItem.setCreatedBy(newOrder.getCreatedBy());
            newLineItem.setModifiedDate(newOrder.getModifiedDate());
            newLineItem.setModifiedBy(newOrder.getModifiedBy());
            allItems.add(newLineItem);
        }
        lineItemRepo.saveAll(allItems);
        System.out.println(allItems);

        orderResponse.setStatus("new");
        return orderResponse;
    }


    public Order getOrderById(int id) {

        return repository.findById(id).orElse(null);
    }
    public List<Order> getOrders() {
        return repository.findAll();
    }
    public String deleteOrder(int id) {
        lineItemRepo.deleteALLByOrderId(id);

        repository.deleteById(id);
        return "Order removed !!";
    }
    public String deleteItem(RemoveItemRequest removeItemRequest) {

        // get all items in the order
        lineItemRepo.deleteByOrderIdAndNumber(removeItemRequest.getOrderId(),removeItemRequest.getItemId());
        List<OrderLineItem> itemsPerOrder = lineItemRepo.getAllByOrderId(removeItemRequest.getOrderId());
        return "Item removed !!";
    }
    public String updateQuantity(int orderId, int itemId,double quantity) {

        OrderLineItem existingItem = lineItemRepo.findById(orderId).orElse(null);
        existingItem.setQuantity(quantity);
        lineItemRepo.save(existingItem);
        return "Item updated !!" + itemId;
    }



}
