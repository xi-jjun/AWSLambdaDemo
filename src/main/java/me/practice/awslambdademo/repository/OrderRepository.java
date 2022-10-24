package me.practice.awslambdademo.repository;

import me.practice.awslambdademo.domain.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class OrderRepository {
	private static int id = 5;
	private final List<Order> orders = new ArrayList<>();

	@PostConstruct
	public void buildOrderList() {
		orders.add(new Order(1, "JPA Book", 24000, 10));
		orders.add(new Order(2, "How to make Coffee", 19000, 4));
		orders.add(new Order(3, "Spring boot master course", 29000, 1));
		orders.add(new Order(4, "Mac m1", 1199999, 6));
	}

	public Order findByName(String name) {
		return orders.stream()
				.filter(order -> order.getName().equals(name))
				.findFirst()
				.orElse(Order.builder()
						.message("Not Existed Order")
						.build()
				);
	}

	public List<Order> findAllOrders() {
		return orders;
	}

	public Order makeOrder(Order order) {
		order.setId(id++);
		orders.add(order);
		return order;
	}
}
