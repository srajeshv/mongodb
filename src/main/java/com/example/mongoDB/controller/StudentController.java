package com.example.mongoDB.controller;

import com.example.mongoDB.dto.EmployeeDto;
import com.example.mongoDB.dto.Post;
import com.example.mongoDB.dto.PostDto;
import com.example.mongoDB.dto.StudentDto;
import com.example.mongoDB.entity.StudentEntity;
import com.example.mongoDB.service.ProxyService;
import com.example.mongoDB.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController
{
    @Autowired
    StudentService studentService;

    @Autowired
    ProxyService proxyService;

    @PostMapping("/create")
    public String saveStudentDetails(@RequestBody StudentDto studentDto){
        String respone =studentService.saveStudentDetails(studentDto);
        return respone;
    }
    @PutMapping("/update")
    public String updateStudentDetails(@RequestBody StudentDto studentDto){
        String respone =studentService.updateStudentDetails(studentDto);
        return respone;
    }
    @GetMapping("/get/id")
    public Optional<StudentEntity> getStudentDetails(@RequestParam String id){
        return studentService.getStudentDetailsById(id);
    }
    @GetMapping("/get")
    public List<StudentEntity> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentDetails(@PathVariable String id){
        String respone =studentService.deleteStudentDetails(id);
        return respone;
    }

//    -----------------------------------------------------------------------------
    @GetMapping("/post")
    List<Post> getPostDetails(){
        return proxyService.getPostDetails();
    }

    @PostMapping("/post")
    ResponseEntity<PostDto> savePostData(@RequestBody PostDto postDto) throws JsonProcessingException {
        return proxyService.createPost(postDto);
    }

    @PostMapping("/employee")
    public EmployeeDto saveEmployeetDetails(@RequestBody EmployeeDto departmentDto) throws JsonProcessingException {
        return proxyService.saveEmployeeDetails(departmentDto);
    }

    @GetMapping("/post/get/{id}")
    public PostDto getPostById(@PathVariable long id){
        return proxyService.getPostDetailsById(id);
    }

    @GetMapping("/post/get1/{id}")
    public PostDto getPostById1(@PathVariable String id){
        return proxyService.getPostDetailsById1(id);
    }
}
