package com.example.mongoDB.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Cloneable
{
    private long id;

    private String title;

    private String description;

    private String content;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
