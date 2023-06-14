package com.example.mongoDB.mapper;

import com.example.mongoDB.Repository.StudentRepo;
import com.example.mongoDB.dto.StudentDto;
import com.example.mongoDB.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper
{
    @Autowired
    StudentRepo studentRepo;
    public String tranformDtoToEntity(StudentDto studentDto){
        try {
            StudentEntity studentEntity = new StudentEntity(studentDto.getId(), studentDto.getStudentName(), studentDto.getStudentEmail(), studentDto.getSubjectList(), studentDto.getDepartment(),0.00);
            studentRepo.save(studentEntity);
            return "Success";
        }catch (Exception exception){
            return "Failed"+exception.getMessage();
        }
    }
}
