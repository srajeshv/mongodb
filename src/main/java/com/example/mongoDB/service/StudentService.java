package com.example.mongoDB.service;

import com.example.mongoDB.dto.StudentDto;
import com.example.mongoDB.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    String saveStudentDetails(StudentDto studentDto);

    String updateStudentDetails(StudentDto studentDto);

    Optional<StudentEntity> getStudentDetailsById(String id);

    List<StudentEntity> getAllStudentDetails();

    String deleteStudentDetails(String id);
}
