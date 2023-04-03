package com.example.chapter_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
