package com.vichhaicoder.demo_mybatis.dto.request;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookRequest {
    private String title;
    private LocalDateTime publishedDate;
    private Integer authorId;
}
