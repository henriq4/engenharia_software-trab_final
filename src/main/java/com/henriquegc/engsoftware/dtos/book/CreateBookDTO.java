package com.henriquegc.engsoftware.dtos.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookDTO {
    private String title;
    private String description;
    private Long authorId;
    private Long publisherId;
    private String isbn;
    private int year;
    private int pages;
}
