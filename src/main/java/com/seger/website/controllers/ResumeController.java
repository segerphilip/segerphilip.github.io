package com.seger.website.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ResumeController {
    private static final String resumeName = "PhilipSegerResume.pdf";

    /**
     * GET /resume will download PhilipSegerResume.pdf to client's browser
     * @return PDF file
     */
    @GetMapping("/resume")
    public ResponseEntity<byte[]> resume() {
        try {
            Resource resource = new ClassPathResource(resumeName);
            byte[] pdf = Files.readAllBytes(Paths.get(resource.getURI()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData(resumeName, resumeName);
            ResponseEntity<byte[]> response = new ResponseEntity<>(pdf, headers, HttpStatus.OK);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
