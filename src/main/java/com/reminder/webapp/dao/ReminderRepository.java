package com.reminder.webapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reminder.webapp.model.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Integer>
{
	
	@Query("SELECT R FROM Reminder R JOIN User U ON U.userId = R.reminderId where U.email =?1")
	public List<Reminder> geAllByUserEmail(String email);

}
