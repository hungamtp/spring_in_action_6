package com.example.chapter_2.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Burger {
    private Integer id;
    private String name;
    private String favor;
    private Boolean isHidden;
}
