package com.vichhaicoder.demo_mybatis.modal;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Book {
    private Integer bookId;
    private String title;
    private LocalDateTime publishedDate;
    private Author authors;
    private List<Category> categoryList = new ArrayList<>();
}
