package me.practice.awslambdademo.domain;

import lombok.Data;

@Data
public class OrderResponseDto {
	private int id;
	private String name;

	public OrderResponseDto(Order order) {
		this.id = order.getId();
		this.name = order.getName();
	}
}
