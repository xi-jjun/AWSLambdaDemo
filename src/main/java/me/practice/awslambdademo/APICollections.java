package me.practice.awslambdademo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.practice.awslambdademo.domain.ItemRegisterDto;
import me.practice.awslambdademo.domain.OrderRequestDto;
import me.practice.awslambdademo.domain.ResponseDto;
import me.practice.awslambdademo.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@RequiredArgsConstructor
@Component
public class APICollections {
	private final OrderService orderService;

	@Bean
	public Function<ItemRegisterDto, ResponseDto<?>> registerItem() {
		return orderService::registerItem;
	}

	@Bean
	public Supplier<ResponseDto<?>> getAllItemList() {
		return orderService::getTotalItemList;
	}

	@Bean
	public Function<OrderRequestDto, ResponseDto<?>> orderItem() {
		return orderService::orderItem;
	}

	@Bean
	public Function<String, ResponseDto<?>> getItem() {
		return orderService::getItem;
	}

	@Bean
	public Supplier<ResponseDto<?>> getTotalOrderList() {
		return orderService::getTotalOrderList;
	}
}
