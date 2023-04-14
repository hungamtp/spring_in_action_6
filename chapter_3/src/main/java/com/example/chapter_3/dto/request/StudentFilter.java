package com.example.chapter_3.dto.request;

import com.example.chapter_3.dto.Filter;
import lombok.*;


@Getter
public class StudentFilter extends Filter {
    private String name;

    @Builder
    public StudentFilter(int page, int size, String name) {
        super(page, size);
        this.name = name;
    }
}
