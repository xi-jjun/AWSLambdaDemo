package me.practice.awslambdademo;

import me.practice.awslambdademo.domain.OrderRequestDto;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

// 여기 클래스의 Generic 이 바로 Serialize 해주는 역할
public class LambdaHandler extends SpringBootRequestHandler<OrderRequestDto, Object> {

}
