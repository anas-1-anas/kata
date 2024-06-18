package com.carrefour.DeliveryApp.service;

import com.carrefour.DeliveryApp.exception.ResourceNotFoundException;
import com.carrefour.DeliveryApp.model.DeliveryMethod;
import com.carrefour.DeliveryApp.model.TimeSlot;
import com.carrefour.DeliveryApp.repository.DeliveryMethodRepository;
import com.carrefour.DeliveryApp.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryMethodRepository deliveryMethodRepository;
    private final TimeSlotRepository timeSlotRepository;

    public DeliveryServiceImpl(DeliveryMethodRepository deliveryMethodRepository, TimeSlotRepository timeSlotRepository) {
        this.deliveryMethodRepository = deliveryMethodRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    public Mono<DeliveryMethod> createDeliveryMethod(DeliveryMethod deliveryMethod) {
        return deliveryMethodRepository.save(deliveryMethod);
    }

    public Flux<DeliveryMethod> getAllDeliveryMethods() {
        return deliveryMethodRepository.findAll();
    }

    public Mono<TimeSlot> createTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    public Flux<TimeSlot> getTimeSlotsByMethod(String method) {
        return timeSlotRepository.findByMethod(method).switchIfEmpty(Flux.error(new ResourceNotFoundException("No time slots found for method: " + method)));
    }
}