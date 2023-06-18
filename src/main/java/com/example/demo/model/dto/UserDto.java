package com.example.demo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {
	
	private String userId;
	
	private String pw;
	
	private String adminRole;

}
