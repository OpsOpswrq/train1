package com.feng.dao;

import com.feng.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {
    void insertArticle(Article article);
    List<Article> queryAllArticles();
    void updateArticle(Article article);
    Article getArticle(int id);
    void deleteArticle(int id);
}
