package com.example.chapter_3.service.impl;

import com.example.chapter_3.dto.request.StudentFilter;
import com.example.chapter_3.dto.response.PageDTO;
import com.example.chapter_3.dto.response.StudentDTO;
import com.example.chapter_3.entity.Class;
import com.example.chapter_3.entity.Student;
import com.example.chapter_3.entity.StudentClass;
import com.example.chapter_3.repo.StudentClassRepository;
import com.example.chapter_3.repo.StudentRepository;
import com.example.chapter_3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentClassRepository studentClassRepository;
    private final EntityManager entityManager;


    @Override
    public PageDTO<StudentDTO> getStudents(StudentFilter filter) {
        Page<Student> students = studentRepository.findAllByNameLike(filter.getName(), PageRequest.of(filter.getPage(), filter.getSize()));

        return PageDTO.<StudentDTO>builder()
                .page(filter.getPage())
                .size(filter.getSize())
                .totalPage(students.getTotalPages())
                .totalResult(students.getNumberOfElements())
                .data(students.stream().map(StudentDTO::entityToDTO).collect(Collectors.toList()))
                .build();
    }

    @Override
    public StudentDTO addStudent(StudentDTO student) {
        studentRepository.save(Student.builder()
                        .studentCode(student.getStudentCode())
                        .name(student.getName())
                .build());
        return student;
    }

    @Override
    public Boolean deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
        return true;
    }

    @Override
    public Boolean joinClass(Integer studentId, Integer classId) {
        studentClassRepository.save(StudentClass.builder().className(entityManager.getReference(Class.class , classId))
                        .student(entityManager.getReference(Student.class, studentId))
                .build());
        return true;
    }


}
