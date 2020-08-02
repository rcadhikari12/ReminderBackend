package com.reminder.webapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reminder.webapp.model.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Integer>
{
	
	@Query(value ="select * from reminder R where R.user_id = ?1", nativeQuery = true)
	public List<Reminder> geAllByUserEmail(int id);
	
	
	

}
