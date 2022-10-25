package com.tli.orders.repository;

import com.tli.orders.entity.OrderLineItem;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface LineItemRepository extends JpaRepository<OrderLineItem,Integer> {
    void deleteALLByOrderId(int id);
    List<OrderLineItem> getAllByOrderId(int id);

    @Transactional
    void deleteByOrderIdAndNumber(int id, int number);
}

