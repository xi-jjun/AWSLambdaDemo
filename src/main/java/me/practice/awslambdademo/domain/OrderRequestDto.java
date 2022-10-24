package me.practice.awslambdademo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequestDto {
	private String name;
	private int price;
	private int quantity;

	public Order toEntity() {
		return Order.builder()
				.name(name)
				.price(price)
				.quantity(quantity)
				.build();
	}
}
