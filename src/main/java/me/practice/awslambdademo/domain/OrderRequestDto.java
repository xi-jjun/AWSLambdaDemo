package me.practice.awslambdademo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
