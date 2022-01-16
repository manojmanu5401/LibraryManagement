package com.example.demo.Models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Books {
    private String bookName;
    private String bookId;
    private String author;
}
