package com.techprimers.springbootwebsocketexample.resource;

import com.techprimers.springbootwebsocketexample.entity.Sensor_h11;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import com.techprimers.springbootwebsocketexample.repository.Testrepositoryh11;
import com.techprimers.springbootwebsocketexample.service.ServiceH11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

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
                i = 10;
                newdata = serviceH11.addSensorh11(name_temp, sal_temp, name_hum, sal_hum, createBy);
                testrepositoryh11.save(newdata);

                StringBuilder sb = new StringBuilder(newdata.getName_hum()+"---");
                sb.append(String.valueOf(newdata.getValuee_hum()));

                template.convertAndSend("/topic/user", new UserResponse(sb.toString() ));

                return null;
               // return "<html><body><h1>This record  was added</h1><p>" + newdata.toString() + "</p></body></html>";

            }

        } catch (Exception e) {
            e.printStackTrace();
            return "There is no such item";
        }

        return "Param {game} is ----" + null;
    }



}
