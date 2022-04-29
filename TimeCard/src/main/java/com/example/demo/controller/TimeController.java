package com.example.demo.controller;

import java.time.LocalTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Controller
public class TimeController {
	@Autowired
	UserMapper userMapper;

	@GetMapping("/by")
	public String formTime(Model model) {
		model.addAttribute("user", new User());
		return"form";
	}
	@PostMapping("/entertime")
	//public String timecardin(@ModelAttribute User user,Model model) {
		public String enterin(@Valid User user ,BindingResult result, Model model) {
		if (result.hasErrors()) {
		return"form";
	} else {
		model.addAttribute("msg", "出勤しました..........");
		LocalTime l = LocalTime.now();
		user.setInTime(l);
		userMapper.doinsert(user);
		
		return"form";
	}
	}
		@PostMapping("/outtime")
		//public String timecardin(@ModelAttribute User user,Model model) {
			public String outtimer(@Valid User user ,BindingResult result, Model model) {
			if (result.hasErrors()) {
			return"form";
		} else {
			model.addAttribute("msgg", "退勤しました..........");
			LocalTime l = LocalTime.now();
            user.setOutTime(l);
            //userMapper.doinsert(user);
			userMapper.doupdate(user);
			return"form";
		}
	}
}
