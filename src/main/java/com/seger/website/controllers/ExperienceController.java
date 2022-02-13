package com.seger.website.controllers;

import com.seger.website.Experience;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {
    @GetMapping("/experience")
    public Experience experience() {
        return null;
    }
}
