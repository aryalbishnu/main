package com.example.demo.entity;

import java.time.LocalTime;

import lombok.Data;
@Data
public class Try {
	private String username;
	private LocalTime inTime;
	private LocalTime outTime;
}
