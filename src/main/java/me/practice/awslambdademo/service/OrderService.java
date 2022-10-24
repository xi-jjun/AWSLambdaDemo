package me.practice.awslambdademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.practice.awslambdademo.domain.Order;
import me.practice.awslambdademo.domain.OrderRequestDto;
import me.practice.awslambdademo.domain.OrderResponseDto;
import me.practice.awslambdademo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderResponseDto orderItem(OrderRequestDto orderRequestDto) {
		log.info("OrderService - orderItem() called");

		Order order = orderRequestDto.toEntity();
		log.info("user register item => {}", order.toString());
		log.info("before user register item => {}", getTotalItemSize());
		orderRepository.makeOrder(order);
		log.info("after user register item => {}", getTotalItemSize());

		return new OrderResponseDto(order);
	}

	public List<OrderResponseDto> getOrders() {
		return orderRepository.findAllOrders().stream()
				.map(OrderResponseDto::new)
				.collect(Collectors.toList());
	}

	public int getTotalItemSize() {
		return orderRepository.findAllOrders().size();
	}
}
