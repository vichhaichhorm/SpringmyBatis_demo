package com.vichhaicoder.demo_mybatis.dto.response;

import com.vichhaicoder.demo_mybatis.modal.Author;
import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookResponse {
    private Integer bookId;
    private String title;
    private LocalDateTime publishedDate;
    private AuthorResponse authors;

}
