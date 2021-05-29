package com.demka.blogexample.entities.request;

import lombok.Data;

import java.util.List;

@Data
public class PostRequestEntity {
    private Long authorPost;
    private List<Long> tags;
    private String text;
    private String title;
}
