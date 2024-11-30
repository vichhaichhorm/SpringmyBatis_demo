package com.vichhaicoder.demo_mybatis.modal;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Author {
    private Integer authorId;
    private String name;
    private String gender;
}
