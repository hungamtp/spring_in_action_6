package com.example.chapter_3.controller;

import com.example.chapter_3.dto.response.ClassDTO;
import com.example.chapter_3.dto.response.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassController {
    
    @GetMapping
    public PageDTO<ClassDTO> getClasses(@RequestParam(required = false) String name, @RequestParam int page, @RequestParam int size){
        return null;
    }
}
