package com.example.mongoDB.dto;

import com.example.mongoDB.entity.Department;
import com.example.mongoDB.entity.Subject;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto
{
    private String id;
    private String studentName;

    private String studentEmail;

    private List<Subject> subjectList;

    private Department department;
}
