package com.techprimers.springbootwebsocketexample.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserResponse {
    String content;
    String dataString;



    public UserResponse() {

    }

    public String getDataString() {
        return dataString;
    }

    public UserResponse(String content ) {
        this.content = content;
    }

    public UserResponse(String content, String dataString ) {
        this.dataString = dataString;
        this.content = content;
    }

    public String getContent() {
        return content;
    }



}
