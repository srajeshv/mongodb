package com.example.mongoDB.serviceImpl;

import com.example.mongoDB.Repository.StudentRepo;
import com.example.mongoDB.dto.StudentDto;
import com.example.mongoDB.entity.StudentEntity;
import com.example.mongoDB.mapper.StudentMapper;
import com.example.mongoDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveStudentDetails(StudentDto studentDto) {
        return studentMapper.tranformDtoToEntity(studentDto);
    }

    @Override
    public String updateStudentDetails(StudentDto studentDto) {
        return studentMapper.tranformDtoToEntity(studentDto);
    }

    @Override
    public Optional<StudentEntity> getStudentDetailsById(String id) {
        studentRepo.findByDepartmentDepartmentName("ME");
        studentRepo.findByDepartmentDepartmentName("Electrical");
        return studentRepo.findById(id);
    }

    @Override
    public List<StudentEntity> getAllStudentDetails() {
        return studentRepo.findAll();
    }

    @Override
    public String deleteStudentDetails(String id) {
        studentRepo.deleteById(id);
        return "delete student details";
    }


}
