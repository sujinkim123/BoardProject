package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.OptionMapper;
import com.example.demo.model.dto.UserDto;

@Service
public class OptionService {
	
	@Autowired
	OptionMapper optionMapper;
	
	public List<UserDto> cateList() {
		return optionMapper.cateList();
	}

}
