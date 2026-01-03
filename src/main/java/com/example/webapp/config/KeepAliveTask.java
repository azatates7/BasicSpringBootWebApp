package com.example.webapp.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeepAliveTask {

    private final RestTemplate restTemplate = new RestTemplate();

@Scheduled(fixedRate = 600000) // 600k ms = 10 minutes
public void keepAlive() {
        try {
            String url = "https://azatates.com/";
            restTemplate.getForObject(url, String.class);
            System.out.println("Ping sended, application alive.");
        } catch (Exception e) {
            System.err.println("Ping Error: " + e.getMessage());
        }
    }
}