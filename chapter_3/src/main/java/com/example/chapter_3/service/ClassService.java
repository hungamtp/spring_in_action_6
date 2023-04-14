package com.example.chapter_3.service;

import com.example.chapter_3.dto.request.ClassFilter;
import com.example.chapter_3.dto.response.ClassDTO;
import com.example.chapter_3.dto.response.PageDTO;

public interface ClassService {
    PageDTO<ClassDTO> getClass(ClassFilter filter);
}
