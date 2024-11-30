package com.vichhaicoder.demo_mybatis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private Integer authorId;
    private String name;
    private String gender;
}
