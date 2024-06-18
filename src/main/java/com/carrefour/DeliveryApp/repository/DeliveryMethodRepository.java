package com.carrefour.DeliveryApp.repository;

import com.carrefour.DeliveryApp.model.DeliveryMethod;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryMethodRepository extends ReactiveCrudRepository<DeliveryMethod, Long> {
}