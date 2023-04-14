package com.example.chapter_3.service;


import com.example.chapter_3.dto.request.StudentFilter;
import com.example.chapter_3.dto.response.PageDTO;
import com.example.chapter_3.dto.response.StudentDTO;

public interface StudentService {
    PageDTO<StudentDTO> getStudents(StudentFilter filter);
    StudentDTO addStudent(StudentDTO student);
    Boolean deleteStudent(Integer studentId);
    
    Boolean joinClass(Integer studentId , Integer classId);
    
}
