package com.example.mongoDB.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.CollectionUtils;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student")
public class StudentEntity
{
    @Id
    private String id;

    private String name;

    @Field(name = "mail")
    private String email;

    @Field(name = "subject")
    private List<Subject> subjectList;

    private Department department;

    @Transient
    private double percentage;

    public double getPercentage() {
        if(!CollectionUtils.isEmpty(subjectList)){
            int total =0;
            for (Subject s : subjectList) {
                total += Integer.parseInt(s.getMarksObtained());
            }
            return total/subjectList.size();
        }
        return 0.00;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
