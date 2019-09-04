package com.techprimers.springbootwebsocketexample.service;


import com.techprimers.springbootwebsocketexample.entity.Sensor_h11;
import org.springframework.stereotype.Service;

@Service
public interface ServiceH11 {


    Sensor_h11 addSensorh11(String name_temp, float valuee_temp, String name_hum,
                            float valuee_hum, String createBy);
}
