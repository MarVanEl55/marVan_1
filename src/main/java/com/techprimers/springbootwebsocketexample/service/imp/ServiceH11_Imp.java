package com.techprimers.springbootwebsocketexample.service.imp;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.techprimers.springbootwebsocketexample.entity.Sensor_h11;
import com.techprimers.springbootwebsocketexample.service.ServiceH11;

@Service
public class ServiceH11_Imp implements ServiceH11 {

	@Override
	public Sensor_h11 addSensorh11(final String name_temp, final float valuee_temp, final String name_hum,
			final float valuee_hum, final String createBy) {

		Sensor_h11 newdata = new Sensor_h11();
		newdata.setName_hum(name_hum);
		newdata.setName_temp(name_temp);
		newdata.setValuee_hum(valuee_hum);
		newdata.setValuee_temp(valuee_temp);
		newdata.setCreateBy(createBy);
		newdata.setTmspCrea(getActualDate());
		return newdata;
	}

	public Timestamp getActualDate() {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}
}
