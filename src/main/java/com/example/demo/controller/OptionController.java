package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OptionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "admin")
public class OptionController {
	
	@Autowired
	OptionService optionService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test(Model model) throws Exception {
		
		System.out.println("테스트 시작");
		
		ObjectMapper objm = new ObjectMapper();
		
		List list = optionService.cateList(); 
		
		String cateList = objm.writeValueAsString(list);
		
		model.addAttribute("cateList", cateList);
		
		System.out.println(">>> 변경 전 : " + list);
		System.out.println(">>> 변경 후 : " + cateList);
		
	}
	
}
