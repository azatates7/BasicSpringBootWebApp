package com.example.webapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class KeepAliveTask {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final Logger log = LoggerFactory.getLogger(KeepAliveTask.class);
    DateFormatHelper dateFormatHelper = new DateFormatHelper();

@Scheduled(fixedRate = 600000) // 600k ms = 10 minutes
public void keepAlive() {
        try {
            var urls = List.of(
                "https://basicspringbootwebapp.onrender.com/",
                        "https://azatates.com/"
            );

            for (String url : urls) {
                var date = String.format("Ping requests sended at [%s], application alive.", dateFormatHelper.convertMyDateFormat());
                try{
                    restTemplate.getForObject(url, String.class);
                    log.info("Ping sent to {} request date {}", url, date);
                }
                catch(Exception exception){
                    restTemplate.getForObject(url, String.class);
                    log.error("Ping failed for {} - {}", url, exception.getMessage());                }
            }

            System.out.println();
        } catch (Exception e) {
            log.error("Ping failed - {}", e.getMessage());
        }
    }
}