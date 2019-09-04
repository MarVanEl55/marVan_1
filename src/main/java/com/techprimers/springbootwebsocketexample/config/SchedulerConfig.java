package com.techprimers.springbootwebsocketexample.config;

import com.techprimers.springbootwebsocketexample.model.UserResponse;
import com.techprimers.springbootwebsocketexample.repository.Testrepositoryh11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    private static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";

//    @Autowired
//    private Testrepositoryh11 testrepositoryh11;

//
//    @Scheduled(fixedDelay =10000)
//    public void sendAdhocMessages_2() {
//        StringBuilder sb = new StringBuilder("Actual Date - ");
//        sb.append(getDateAsString());
//        template.convertAndSend("/topic/user", new UserResponse(sb.toString() ));
//    }

    private String getDateAsString(){
        Date d = new Date();
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String formattedDate = formatter.format(d);
        return formattedDate;
    }
}