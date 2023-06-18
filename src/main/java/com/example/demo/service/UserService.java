package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;


@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public ArrayList<HashMap<String, Object>> findAll() {
		return userMapper.findAll();
	}

}
