package com.techprimers.springbootwebsocketexample.resource;

import com.techprimers.springbootwebsocketexample.entity.Sensor_h11;
import com.techprimers.springbootwebsocketexample.model.User;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import com.techprimers.springbootwebsocketexample.repository.Testrepositoryh11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import java.sql.Timestamp;
import java.util.Date;

@Controller
public class UserController {




    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) {
        System.out.println("-------SAVE------");
        return new UserResponse("Sent: " + user.getName());
    }


    public Timestamp getActualDate() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts;
    }
}
