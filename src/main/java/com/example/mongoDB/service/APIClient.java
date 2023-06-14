package com.example.mongoDB.service;
import com.example.mongoDB.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/*@FeignClient(url = "http://localhost:9999",value = "BLOG-SERVICE")
public interface APIClient {
    @GetMapping("/blog/api/v1/allPostAndCommentDetails")
    List<Post> getAllPostAndCommentDetails();
}*/
