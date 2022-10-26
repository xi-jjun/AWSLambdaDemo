package me.practice.awslambdademo.handlers;

import me.practice.awslambdademo.domain.ItemRegisterDto;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class ItemHandler extends SpringBootRequestHandler<ItemRegisterDto, Object> {
}
