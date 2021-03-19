package com.mit.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	private String name = "나는 요리사";
}
