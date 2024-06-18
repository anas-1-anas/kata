package com.carrefour.DeliveryApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class DeliveryMethod {

    @Id
    private Long id;
    private String method;

    public DeliveryMethod() {
    }

    public DeliveryMethod(String method) {
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}