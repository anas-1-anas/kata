package com.carrefour.DeliveryApp.controller;

import com.carrefour.DeliveryApp.model.DeliveryMethod;
import com.carrefour.DeliveryApp.model.TimeSlot;
import com.carrefour.DeliveryApp.service.DeliveryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryServiceImpl deliveryServiceImpl;

    public DeliveryController(DeliveryServiceImpl deliveryServiceImpl) {
        this.deliveryServiceImpl = deliveryServiceImpl;
    }

    @PostMapping("/methods")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DeliveryMethod> createDeliveryMethod(@RequestBody DeliveryMethod deliveryMethod) {
        return deliveryServiceImpl.createDeliveryMethod(deliveryMethod);
    }

    @GetMapping("/methods")
    public Flux<DeliveryMethod> getAllDeliveryMethods() {
        return deliveryServiceImpl.getAllDeliveryMethods();
    }

    @PostMapping("/timeslots")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TimeSlot> createTimeSlot(@RequestBody TimeSlot timeSlot) {
        return deliveryServiceImpl.createTimeSlot(timeSlot);
    }

    @GetMapping("/timeslots")
    public Flux<TimeSlot> getTimeSlotsByMethod(@RequestParam String method) {
        return deliveryServiceImpl.getTimeSlotsByMethod(method);
    }
}