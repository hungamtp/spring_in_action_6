package com.example.chapter_3.dto.response;

import com.example.chapter_3.entity.Class;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDTO {
    private Integer id;
    private String name;
    public static ClassDTO entityToDTO(Class entity){
        return ClassDTO.builder()
                .name(entity.getName())
                .id(entity.getId())
                .build();
    }
}
