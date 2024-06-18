package com.carrefour.DeliveryApp.repository;

import com.carrefour.DeliveryApp.model.TimeSlot;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TimeSlotRepository extends ReactiveCrudRepository<TimeSlot, Long> {

    Flux<TimeSlot> findByMethod(String method);
}