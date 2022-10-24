package me.practice.awslambdademo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.practice.awslambdademo.domain.Order;
import me.practice.awslambdademo.domain.OrderRequestDto;
import me.practice.awslambdademo.domain.OrderResponseDto;
import me.practice.awslambdademo.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Component
public class APICollections {
	private final OrderService orderService;

	@Bean
	public Function<OrderRequestDto, OrderResponseDto> registerOrderItem() {
		orderService.getOrders()
				.forEach(order -> log.info(order.toString()));
		return orderService::orderItem;
	}

	@Bean
	public Function<String, String> reverse() {
		return (input) -> new StringBuilder(input).reverse().toString();
	}

	@Bean
	public Supplier<List<OrderResponseDto>> getOrderList() {
		return orderService::getOrders;
	}
}
