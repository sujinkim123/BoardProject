package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.dto.UserDto;

@Service
public class TestService {
	
	@Autowired
	TestMapper testMapper;
	
	public List<UserDto> getUsers() {
		return testMapper.getUsers();
	}

}
