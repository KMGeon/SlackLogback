package com.example.createslack;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Scheduledf를 이용한
 */
@Controller
public class shedule {

    @Scheduled(fixedRate = 3000)
    @PostMapping("/publish/slack")
    public void send() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = new HashMap<>();
        request.put("username", "하하"); //slack bot name
        request.put("text", String.valueOf(1234)); //전송할 메세지
        request.put("icon_emoji", "img"); //slack bot image

        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);

        String url = "https://hooks.slack.com/servicesxxxx"; //복사한 Webhook URL 입력

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

}
