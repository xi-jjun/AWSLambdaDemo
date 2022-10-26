package me.practice.awslambdademo.handlers;

import me.practice.awslambdademo.domain.OrderRequestDto;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

/**
 * String : 주문할 상품의 이름
 * Object : 반환 객체
 */
public class OrderHandler extends SpringBootRequestHandler<OrderRequestDto, Object> {

}
