package com.reminder.webapp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.reminder.webapp.dao.ReminderRepository;
import com.reminder.webapp.dao.UserRepository;
import com.reminder.webapp.model.Reminder;
import com.reminder.webapp.model.User;

@Service
public class ReminderService {
	@Autowired
	private ReminderRepository reminderRepository;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserRepository userRepository;

	public Reminder createReminder(Reminder reminder, String email) {
		Optional<User> userEmailObj = userRepository.findByEmail(email);
		User user = userEmailObj.get();
		reminder.setUser(user);
		return reminderRepository.save(reminder);

	}

	public void deleteReminder(int reminderId) {
		reminderRepository.deleteById(reminderId);
	}

	public List<Reminder> getAllReminders() {
		return reminderRepository.findAll();
	}

	public List<Reminder> getAllRemindersByUser(String email) {
		return reminderRepository.geAllByUserEmail(email);
	}

	@Scheduled(fixedRate = 30000)
	public void sendReminder() {

		List<Reminder> reminderList = getAllReminders();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
		String todayDate = formatter.format(date);
		String todayTime = formatterTime.format(date);

		for (Reminder reminder : reminderList) {
			String dbDate = formatter.format(reminder.getEventReminderDate());
			String dbTime = formatterTime.format(reminder.getEventReminderTime());

			if (todayDate.equals(dbDate) && dbTime.equals(todayTime)) {
				System.out.println("working fine");
				System.out.println("today date" + todayDate + "today time" + todayTime);
			}

		}

		// mailService.sendEmail();

	}

}
