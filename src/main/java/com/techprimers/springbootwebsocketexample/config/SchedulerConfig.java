package com.techprimers.springbootwebsocketexample.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class SchedulerConfig {

	@Autowired
	SimpMessagingTemplate template;

	private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";

	private String getDateAsString() {
		Date d = new Date();
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		String formattedDate = formatter.format(d);
		return formattedDate;
	}
}