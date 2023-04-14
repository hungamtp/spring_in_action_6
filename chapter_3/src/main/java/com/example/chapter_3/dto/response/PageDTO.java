package com.example.chapter_3.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDTO<T> {
    private int size;
    private int page;
    private int totalPage;
    private int totalResult;
    private List<T> data;
}
