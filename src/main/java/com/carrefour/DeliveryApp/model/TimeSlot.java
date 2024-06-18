package com.carrefour.DeliveryApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class TimeSlot {

    @Id
    private Long id;
    private String method;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeSlot() {
    }

    public TimeSlot(String method, LocalDateTime startTime, LocalDateTime endTime) {
        this.method = method;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}