package com.carrefour.DeliveryApp;

import com.carrefour.DeliveryApp.model.DeliveryMethod;
import com.carrefour.DeliveryApp.model.TimeSlot;
import com.carrefour.DeliveryApp.repository.DeliveryMethodRepository;
import com.carrefour.DeliveryApp.repository.TimeSlotRepository;
import com.carrefour.DeliveryApp.service.DeliveryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class DeliveryServiceImplTest {

	@Mock
	private DeliveryMethodRepository deliveryMethodRepository;

	@Mock
	private TimeSlotRepository timeSlotRepository;

	@InjectMocks
	private DeliveryServiceImpl deliveryServiceImpl;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateDeliveryMethod() {
		DeliveryMethod method = new DeliveryMethod("NEW_METHOD");
		when(deliveryMethodRepository.save(any())).thenReturn(Mono.just(method));

		Mono<DeliveryMethod> savedMethod = deliveryServiceImpl.createDeliveryMethod(method);

		assertEquals(method.getMethod(), savedMethod.block().getMethod());
		verify(deliveryMethodRepository).save(method);
	}

	@Test
	public void testGetAllDeliveryMethods() {
		when(deliveryMethodRepository.findAll()).thenReturn(Flux.just(
				new DeliveryMethod("DRIVE"),
				new DeliveryMethod("DELIVERY")
		));

		Flux<DeliveryMethod> allMethods = deliveryServiceImpl.getAllDeliveryMethods();

		assertEquals(2, allMethods.collectList().block().size());
		verify(deliveryMethodRepository).findAll();
	}

	@Test
	public void testCreateTimeSlot() {
		TimeSlot slot = new TimeSlot("DRIVE", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
		when(timeSlotRepository.save(any())).thenReturn(Mono.just(slot));

		Mono<TimeSlot> savedSlot = deliveryServiceImpl.createTimeSlot(slot);

		assertEquals(slot.getMethod(), savedSlot.block().getMethod());
		verify(timeSlotRepository).save(slot);
	}

	@Test
	public void testGetTimeSlotsByMethod() {
		String method = "DRIVE";
		when(timeSlotRepository.findByMethod(method)).thenReturn(Flux.just(
				new TimeSlot(method, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
				new TimeSlot(method, LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))
		));

		Flux<TimeSlot> slotsByMethod = deliveryServiceImpl.getTimeSlotsByMethod(method);

		assertEquals(2, slotsByMethod.collectList().block().size());
		verify(timeSlotRepository).findByMethod(method);
	}
}
