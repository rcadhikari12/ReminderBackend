package com.reminder.webapp.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reminder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reminderId;
	
	private String eventName;
	
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date eventReminderDate;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm", timezone = "GMT-5")
	private Date eventReminderTime;
	
	
	@OneToOne()
	@JoinColumn(name = "user_id" ,referencedColumnName = "user_id")
	private User user;
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getReminderId() {
		return reminderId;
	}

	public void setReminderId(int reminderId) {
		this.reminderId = reminderId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventReminderDate() {
		return eventReminderDate;
	}

	public void setEventReminderDate(Date eventReminderDate) {
		this.eventReminderDate = eventReminderDate;
	}

	public Date getEventReminderTime() {
		return eventReminderTime;
	}

	public void setEventReminderTime(Date eventReminderTime) {
		this.eventReminderTime = eventReminderTime;
	}

	public Reminder(int reminderId, String eventName, Date eventReminderDate, Date eventReminderTime) {
		super();
		this.reminderId = reminderId;
		this.eventName = eventName;
		this.eventReminderDate = eventReminderDate;
		this.eventReminderTime = eventReminderTime;
	}

	public Reminder() {
	
	}
	
	
	
	

}
