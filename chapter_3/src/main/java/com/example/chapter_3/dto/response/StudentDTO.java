package com.example.chapter_3.dto.response;

import com.example.chapter_3.entity.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Integer id;
    private String name;
    private String studentCode;
    private List<ClassDTO> classes;
    public static StudentDTO entityToDTO(Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .studentCode(student.getStudentCode())
                .build();
    }
}
