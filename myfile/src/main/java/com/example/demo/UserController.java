package com.example.demo;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Transfer;

import lombok.extern.slf4j.Slf4j;

@Mapper
@Slf4j
@Controller
public class UserController{
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/loging")
	public String userForm(Model model) {
		model.addAttribute("user",new User());
		return"user";
	}
	@PostMapping("/user")
	public String userSubmit(@ModelAttribute User user, Model model) {
		log.info("@@@{}",user);
		userMapper.doinsert(user);
		List<Transfer> getlist = userMapper.getlist();
		model.addAttribute("listuser",getlist);
		log.info("@@@{}",getlist);
		return"sucess";
	}
	
}