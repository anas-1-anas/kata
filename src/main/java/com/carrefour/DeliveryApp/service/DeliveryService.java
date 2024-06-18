package com.carrefour.DeliveryApp.service;

import com.carrefour.DeliveryApp.model.DeliveryMethod;
import com.carrefour.DeliveryApp.model.TimeSlot;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DeliveryService {

    Mono<DeliveryMethod> createDeliveryMethod(DeliveryMethod deliveryMethod);

    Flux<DeliveryMethod> getAllDeliveryMethods();

    Mono<TimeSlot> createTimeSlot(TimeSlot timeSlot);

    Flux<TimeSlot> getTimeSlotsByMethod(String method);
}