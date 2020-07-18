package com.reminder.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reminder.webapp.dao.UserRepository;
import com.reminder.webapp.model.User;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	
	public User registerUser(User user)
	{
		Optional<User> userObj = userRepository.findByEmail(user.getEmail());
		
		if(userObj.isPresent())
		{
			return userObj.get();
		}
		else
		{
			return userRepository.save(user);
		}
		
	}
	
	
	
	

}
