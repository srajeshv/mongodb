package com.example.mongoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Cloneable
{
    private long id;
    private String title;
    private String description;
    private String content;
    private Set<Comment> comments;
}
