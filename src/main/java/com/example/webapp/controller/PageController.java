package com.example.webapp.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class PageController {

    // Main Page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // About Page
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // CV Download
    @GetMapping("/cv/download")
    public ResponseEntity<Resource> downloadCv() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        var url = attributes.getRequest().getRequestURL().toString();
        if (!url.contains("127.0.0.1") && !url.contains("0:0:0:0:0:0:0:1") && !url.contains(("localhost"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Resource resource = new ClassPathResource("static/files/cv.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"cv.pdf\"")
                .body(resource);
    }
}
