package com.marketplace.MarketPlaceProject;

import com.marketplace.MarketPlaceProject.entity.Announcement;
import com.marketplace.MarketPlaceProject.error.AnnouncementNotFoundException;
import com.marketplace.MarketPlaceProject.service.AnnouncementService;
import com.marketplace.MarketPlaceProject.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class MarketPlaceProjectApplication {

	@Autowired
	private EmailSenderService emailService;

	@Autowired
	private AnnouncementService announcementService;

	public static void main(String[] args) {
		SpringApplication.run(MarketPlaceProjectApplication.class, args);
	}
	//https://www.youtube.com/watch?v=kyL0m9y1n0A  +  https://www.baeldung.com/spring-email --pentru trimitere de email

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException, AnnouncementNotFoundException {
		//emailService.sendSimpleEmail("spac.andrei@yahoo.com", "Demo mail message from Spring program", "This is the email subject");
		//emailService.sendAttachementEmail("spac.andrei@yahoo.com", "Demo attachement mail message from Spring program", "This is the email subject", "D:\\AN3-SEM1\\IS\\MarketPlace-Project\\MarketPlace-Project\\SpringBill.txt");
		Long myid = 2222L;
		Announcement announcement = announcementService.fetchAnnouncementById(myid);
		System.out.println(announcement.toString());
	}

}
