package com.techprimers.springbootwebsocketexample.model;


import java.util.Date;

public class UserResponse {
    float valuee_hum;
    float valuee_temp;

    Date date;

    public Date getDate() {
        return date;
    }
    public UserResponse(String s) {
        this.valuee_hum = valuee_hum;
    }

    public UserResponse(float valuee_hum, Date date, float valuee_temp) {
        this.valuee_hum = valuee_hum;
        this.valuee_temp = valuee_temp;
        this.date = date;
    }

    public float getValuee_hum() {
        return valuee_hum;
    }

    public float getValuee_temp() {
        return valuee_temp;
    }
}
