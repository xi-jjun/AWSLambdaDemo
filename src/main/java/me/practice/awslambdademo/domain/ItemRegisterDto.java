package me.practice.awslambdademo.domain;

import lombok.Data;

@Data
public class ItemRegisterDto {
	private String name;
	private int stock;
	private int price;
	public Item toEntity() {
		return Item.builder()
				.name(name)
				.stock(stock)
				.price(price)
				.build();
	}
}
