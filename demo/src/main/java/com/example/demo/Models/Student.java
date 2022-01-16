package com.example.demo.Models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Student {
    private String name;
    private String year;
    private int rollNumber;
    private List<Books> books;
}