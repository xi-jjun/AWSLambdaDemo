package me.practice.awslambdademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
	private Long id;
	private String name;
	private int count;

	public OrderResponseDto(Order order) {
		this.id = order.getId();
		this.name = order.getItem().getName();
		this.count = order.getCount();
	}
}
