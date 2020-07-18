package com.reminder.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.webapp.model.Reminder;
import com.reminder.webapp.service.ReminderService;

@RestController
@CrossOrigin
public class ReminderController 
{
	@Autowired
	private ReminderService reminderService;
	
	@PostMapping("/createReminder/{email}")
	public Reminder createReminderCont(@RequestBody Reminder reminder, @PathVariable("email") String email)
	{
		return reminderService.createReminder(reminder, email);
	}
	
	@GetMapping("/getAllReminders")
	public List<Reminder> getAll()
	{
		return reminderService.getAllReminders();
	}
	
	@DeleteMapping("/deleteReminder/{reminderId}")
	public void deleteReminder(@PathVariable int reminderId)
	{
		reminderService.deleteReminder(reminderId);
	}
	
	@GetMapping("/getRemindersByEmailId/{email}")
	public List<Reminder> getAllReminderEmail(@PathVariable String email)
	{
		return reminderService.getAllRemindersByUser(email);
	}
	
	
	

}
