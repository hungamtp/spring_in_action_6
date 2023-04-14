package com.example.chapter_3.dto.request;

import com.example.chapter_3.dto.Filter;
import lombok.Builder;
import lombok.Getter;


@Getter
public class ClassFilter extends Filter {
    private String name;

    @Builder
    public ClassFilter(int page, int size, String name) {
        super(page, size);
        this.name = name;
    }
}
