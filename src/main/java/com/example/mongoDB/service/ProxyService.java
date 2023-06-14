package com.example.mongoDB.service;

import com.example.mongoDB.dto.EmployeeDto;
import com.example.mongoDB.dto.Post;
import com.example.mongoDB.dto.PostDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProxyService
{
    List<Post> getPostDetails();
    ResponseEntity<PostDto> createPost(PostDto postDto) throws JsonProcessingException;

    EmployeeDto saveEmployeeDetails(EmployeeDto departmentDto) throws JsonProcessingException;

    PostDto getPostDetailsById(long id);

    PostDto getPostDetailsById1(String id);
}
