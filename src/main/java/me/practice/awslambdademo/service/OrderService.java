package me.practice.awslambdademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.practice.awslambdademo.domain.Item;
import me.practice.awslambdademo.domain.ItemRegisterDto;
import me.practice.awslambdademo.domain.Order;
import me.practice.awslambdademo.domain.OrderRequestDto;
import me.practice.awslambdademo.domain.OrderResponseDto;
import me.practice.awslambdademo.domain.ResponseDto;
import me.practice.awslambdademo.repository.ItemRepository;
import me.practice.awslambdademo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final ItemRepository itemRepository;

	@Transactional
	public ResponseDto<?> registerItem(ItemRegisterDto itemRegisterDto) {
		log.info("OrderService - registerItem() called");

		Item item = itemRegisterDto.toEntity();
		if (item.getName().isEmpty()) {
			return ResponseDto.builder()
					.statusCode(400)
					.data("item name is required")
					.build();
		}

		itemRepository.save(item);

		return ResponseDto.builder()
				.statusCode(200)
				.data(item)
				.build();
	}

	@Transactional
	public ResponseDto<?> orderItem(OrderRequestDto orderRequestDto) {
		log.info("OrderService - orderItem() called");

		String orderItemName = orderRequestDto.getName();

		Optional<Item> itemEntity = itemRepository.findByName(orderItemName);
		if (!itemEntity.isPresent()) {
			log.info("order item name '{}' is not existed", orderItemName);
			return ResponseDto.builder()
					.statusCode(400)
					.data("Not found item")
					.build();
		}

		Item orderItem = itemEntity.get();
		Order order = Order.builder()
				.item(orderItem)
				.count(orderRequestDto.getCount())
				.build();
		orderRepository.save(order);

		log.info("user order item name is {}", orderItemName);

		return ResponseDto.builder()
				.statusCode(200)
				.data(order)
				.build();
	}

	public ResponseDto<?> getTotalItemList() {
		return ResponseDto.builder()
				.statusCode(200)
				.data(itemRepository.findAll())
				.build();
	}

	public ResponseDto<?> getItem(String name) {
		Optional<Item> item = itemRepository.findByName(name);
		if (!item.isPresent()) {
			return ResponseDto.builder()
					.statusCode(404)
					.data("Not found item")
					.build();
		}

		return ResponseDto.builder()
				.statusCode(200)
				.data(item.get())
				.build();
	}

	public ResponseDto<?> getTotalOrderList() {
		List<OrderResponseDto> data = orderRepository.findAll().stream()
				.map(OrderResponseDto::new)
				.collect(Collectors.toList());

		return ResponseDto.builder()
				.statusCode(200)
				.data(data)
				.build();
	}
}
