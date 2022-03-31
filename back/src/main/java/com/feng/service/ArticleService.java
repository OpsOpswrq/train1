package com.feng.service;

import com.feng.dao.ArticleDao;
import com.feng.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements ArticleDao {
    @Autowired
    ArticleDao articleDao;
    @Override
    public void insertArticle(Article article) {
        articleDao.insertArticle(article);
    }

    @Override
    public List<Article> queryAllArticles() {
        return articleDao.queryAllArticles();
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public Article getArticle(int id) {
        return articleDao.getArticle(id);
    }

    @Override
    public void deleteArticle(int id) {
        articleDao.deleteArticle(id);
    }
}
