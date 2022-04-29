package com.example.demo.model;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class User {
	@NotBlank
	private String username;
	private LocalTime inTime;
	private LocalTime outTime;
	

}


