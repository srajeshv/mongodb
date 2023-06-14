package com.example.mongoDB.serviceImpl;

import com.example.mongoDB.Repository.StudentRepo;
import com.example.mongoDB.dto.EmployeeDto;
import com.example.mongoDB.dto.Post;
import com.example.mongoDB.dto.PostDto;
import com.example.mongoDB.service.ProxyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class proxyServiceImpl implements ProxyService
{
    @Autowired
    StudentRepo studentRepo;
    @Value("${postAndComment.path}")
    private String postpath;

    @Value("${server.path}")
    private String serverURL;

    @Value("${savepost.path}")
    private String savepostpath;
    @Value("${saveEmployee.path}")
    private String saveEmpleyeepath;

    @Value("${getpost.path}")
    private String getEmpleyeepath;

    @Value("${getpost1.path}")
    private String getEmpleyeepath1;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Post> getPostDetails() {
//        ResponseEntity<DepartmentDto> dtoResponseEntity=restTemplate.getForEntity("http://localhost:9696/api/department/get/"+employee.getDepartmentCode(), DepartmentDto.class);
        ResponseEntity<List> response= restTemplate.getForEntity(serverURL+postpath, List.class);
//        ResponseEntity<Post[]> response= restTemplate.getForEntity(serverURL+postpath, Post[].class);
        List<Post>postList = response.getBody();
//        return apiClient.getAllPostAndCommentDetails();
        return postList;
    }

    @Override
    public ResponseEntity<PostDto> createPost(PostDto postDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(postDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
        ResponseEntity response = restTemplate.postForEntity(serverURL+savepostpath,postDto,PostDto.class);
        return response;
    }

    @Override
    public EmployeeDto saveEmployeeDetails(EmployeeDto employeeDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employeeDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<EmployeeDto> response = restTemplate.postForEntity(serverURL+saveEmpleyeepath,request,EmployeeDto.class);
        return response.getBody();
    }

    @Override
    public PostDto getPostDetailsById(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(headers);
        restTemplate.getForEntity(serverURL+getEmpleyeepath+id, PostDto.class);
        ResponseEntity<PostDto> response= restTemplate.exchange(serverURL+getEmpleyeepath+id, HttpMethod.GET,request, PostDto.class);
        return response.getBody();
    }

    @Override
    public PostDto getPostDetailsById1(String id) {
        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("id",id);
        HttpEntity<String> request = new HttpEntity<>(headers);
//        restTemplate.getForEntity(serverURL+getEmpleyeepath1, PostDto.class,params);
        ResponseEntity<PostDto> response= restTemplate.exchange(serverURL+getEmpleyeepath1, HttpMethod.GET,request, PostDto.class,params);
        return response.getBody();
    }
}
