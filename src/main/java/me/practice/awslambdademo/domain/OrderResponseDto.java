package me.practice.awslambdademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
	private int id;
	private String name;

	public OrderResponseDto(Order order) {
		this.id = order.getId();
		this.name = order.getName();
	}
}
