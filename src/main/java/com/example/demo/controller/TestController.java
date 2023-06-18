package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.TestService;

@RestController
@RequestMapping(value = "api/v1/")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value="getUsers")
	public List<UserDto> getUsers() {
		return testService.getUsers();
	}
}
