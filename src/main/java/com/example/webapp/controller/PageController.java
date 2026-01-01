package com.example.webapp.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
        Resource resource = new ClassPathResource("static/files/cv.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"cv.pdf\"")
                .body(resource);
    }
}
