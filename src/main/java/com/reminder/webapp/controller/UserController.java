package com.reminder.webapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.webapp.model.User;
import com.reminder.webapp.service.UserService;

@RestController
@CrossOrigin
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user)
	{
		return userService.registerUser(user);
	}

	@GetMapping("/")
	public String home()
	{
		return "This is home";
	}
	
	@GetMapping("user")
	@ResponseBody
	public Principal user(Principal pricipal)
	{
		return pricipal;
	}
}
