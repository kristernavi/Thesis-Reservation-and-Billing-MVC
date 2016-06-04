package com.thesis.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thesis.model.User;
import com.thesis.service.UserService;

@Controller
@RequestMapping("auth/over")
public class OverViewController  {

	@Autowired
	public UserService userService;
	@RequestMapping("/")
	public String loadFirst(Map<String,Object>map){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   String name = auth.getName(); //get logged in username
		map.put("currentUser", userService.findUserByName(name));
		return "overview";
		
		
	}
}
