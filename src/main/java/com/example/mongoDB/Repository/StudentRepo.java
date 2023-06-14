package com.example.mongoDB.Repository;

import com.example.mongoDB.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<StudentEntity,String>
{
    List<StudentEntity>findByDepartmentDepartmentName(String name);
}
