package me.practice.awslambdademo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ResponseDto<T> {
	private int statusCode;
	private T data;
}
