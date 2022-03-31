package com.feng.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article {
    private int id;
    private String author;
    private String title;
    private String content;
    public Article(String author,String title,String content){
        this.author = author;
        this.content = content;
        this.title = title;
    }
}
