package com.techprimers.springbootwebsocketexample.resource;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.springbootwebsocketexample.entity.Sensor_h11;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import com.techprimers.springbootwebsocketexample.repository.Testrepositoryh11;
import com.techprimers.springbootwebsocketexample.service.ServiceH11;

@RestController
@RequestMapping("rest")
public class RestControler {

	@Autowired
	private Testrepositoryh11 testrepositoryh11;

	@Autowired
	private ServiceH11 serviceH11;

	@Autowired
	SimpMessagingTemplate template;

	@RequestMapping(value = "/addSensorH11", params = { "name_temp", "valuee_temp", "name_hum",
			"valuee_hum" }, method = RequestMethod.POST)
	public String gameHandler3(@RequestParam("name_temp") String name_temp,
			@RequestParam("valuee_temp") double valuee_temp, @RequestParam("name_hum") String name_hum,
			@RequestParam("valuee_hum") double valuee_hum) {

		Sensor_h11 newdata = null;
		String createBy = "From  module ESP 32";
		int i;
		try {
			float sal_temp = (float) valuee_temp;
			float sal_hum = (float) valuee_hum;

			if (name_temp != null && name_hum != null) {
				newdata = serviceH11.addSensorh11(name_temp, sal_temp, name_hum, sal_hum, createBy);
				testrepositoryh11.save(newdata);
				template.convertAndSend("/topic/user",
						new UserResponse(newdata.getValuee_hum(), new Date(), newdata.getValuee_temp()));
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "There is no such item";
		}

		return "Param {game} is ----" + null;
	}

}
