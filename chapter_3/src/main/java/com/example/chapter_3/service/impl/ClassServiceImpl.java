package com.example.chapter_3.service.impl;

import com.example.chapter_3.dto.request.ClassFilter;
import com.example.chapter_3.dto.response.ClassDTO;
import com.example.chapter_3.dto.response.PageDTO;
import com.example.chapter_3.dto.response.StudentDTO;
import com.example.chapter_3.entity.Class;
import com.example.chapter_3.entity.Student;
import com.example.chapter_3.repo.ClassRepository;
import com.example.chapter_3.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    @Override
    public PageDTO<ClassDTO> getClass(ClassFilter filter) {
        Page<Class> students = classRepository.findAllByNameLike(filter.getName(), PageRequest.of(filter.getPage(), filter.getSize()));

        return PageDTO.<ClassDTO>builder()
                .page(filter.getPage())
                .size(filter.getSize())
                .totalPage(students.getTotalPages())
                .totalResult(students.getNumberOfElements())
                .data(students.stream().map(ClassDTO::entityToDTO).collect(Collectors.toList()))
                .build();
    }
}
