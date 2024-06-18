package com.carrefour.DeliveryApp;

import com.carrefour.DeliveryApp.model.DeliveryMethod;
import com.carrefour.DeliveryApp.model.TimeSlot;
import com.carrefour.DeliveryApp.service.DeliveryServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DeliveryApplicationTest implements CommandLineRunner {

    private DeliveryServiceImpl deliveryServiceImpl;

    public void MainApplicationRunner(DeliveryServiceImpl deliveryServiceImpl) {
        this.deliveryServiceImpl = deliveryServiceImpl;
    }

    public DeliveryApplicationTest(DeliveryServiceImpl deliveryServiceImpl) {
        this.deliveryServiceImpl = deliveryServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create delivery methods
        DeliveryMethod driveMethod = new DeliveryMethod("DRIVE");
        DeliveryMethod deliveryMethod = new DeliveryMethod("DELIVERY");

        deliveryServiceImpl.createDeliveryMethod(driveMethod).block();
        deliveryServiceImpl.createDeliveryMethod(deliveryMethod).block();

        // Create time slots
        LocalDateTime now = LocalDateTime.now();
        TimeSlot slot1 = new TimeSlot("DRIVE", now.plusHours(1), now.plusHours(2));
        TimeSlot slot2 = new TimeSlot("DELIVERY", now.plusDays(1), now.plusDays(1).plusHours(2));

        deliveryServiceImpl.createTimeSlot(slot1).block();
        deliveryServiceImpl.createTimeSlot(slot2).block();

        // Retrieve and print all delivery methods and time slots
        System.out.println("All Delivery Methods:");
        deliveryServiceImpl.getAllDeliveryMethods()
                .doOnNext(method -> System.out.println("Method: " + method.getMethod()))
                .blockLast();

        System.out.println("All Time Slots:");
        deliveryServiceImpl.getTimeSlotsByMethod("DRIVE")
                .doOnNext(slot -> System.out.println("Slot: " + slot.getMethod() + " | Start Time: " + slot.getStartTime() + " | End Time: " + slot.getEndTime()))
                .blockLast();
    }
}