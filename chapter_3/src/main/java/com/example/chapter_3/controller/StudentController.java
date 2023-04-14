package com.example.chapter_3.controller;

import com.example.chapter_3.dto.request.StudentFilter;
import com.example.chapter_3.dto.response.PageDTO;
import com.example.chapter_3.dto.response.StudentDTO;
import com.example.chapter_3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public PageDTO<StudentDTO> getAllStudent(@RequestParam(required = false) String name, @RequestParam int page, @RequestParam int size) {
        StudentFilter filter = StudentFilter.builder().page(page)
                .name(Objects.nonNull(name) ? new StringBuilder().append("%").append(name).append("%").toString() : "%%")
                .size(size).build();
        return studentService.getStudents(filter);
    }

    @PostMapping
    public Boolean addStudent(@RequestBody StudentDTO student) {
        studentService.addStudent(student);
        return true;
    }

    @DeleteMapping("/{studentId}")
    public Boolean removeStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return true;
    }

    @PutMapping
    public Boolean joinClass(@RequestParam Integer studentId, @RequestParam Integer classId) {
        studentService.joinClass(studentId, classId);
        return true;
    }
}
