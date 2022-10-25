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
@Table(name= "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "modified_Date")
    private LocalDate modifiedDate;
    @Column(name = "modified_by")
    private int modifiedBy;

    public Order(int statusId, LocalDate createdDate, int createdBy, LocalDate modifiedDate, int modifiedBy) {
        this.setStatusId(statusId);
        this.setCreatedDate(createdDate);
        this.setCreatedBy(createdBy);
        this.setModifiedDate(modifiedDate);
        this.setModifiedBy(modifiedBy);
    }
}
