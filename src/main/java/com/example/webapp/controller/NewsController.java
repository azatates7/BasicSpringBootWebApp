package com.example.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NewsController {

    @GetMapping("/api/news")
    public Object getNews() {
        String apiKey = "47ba5d35dc2f407793573a2ac8216a17";
        String url = "https://newsapi.org/v2/top-headlines?sources=google-news&pageSize=5&apiKey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Object.class);
    }
}