package com.feng.controller;

import com.alibaba.fastjson.JSONObject;
import com.feng.pojo.Article;
import com.feng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/submitArticle")
    public String submitArticle(@RequestBody Article article){
        articleService.insertArticle(article);
        return "1";
    }
    @GetMapping("/allArticles")
    public String allArticles(){
        return JSONObject.toJSONString(articleService.queryAllArticles());
    }
    @PostMapping("/updateArticle")
    public String updateArticle(@RequestBody JSONObject jsonObject, HttpSession session){
        if(!session.getAttribute("username").equals(articleService.getArticle((Integer) jsonObject.get("id")).getAuthor())){
            return "2";
        }
        Article article = articleService.getArticle((Integer) jsonObject.get("id"));
        article.setContent((String) jsonObject.get("content"));
        article.setTitle((String) jsonObject.get("title"));
        article.setId((Integer) jsonObject.get("id"));
        articleService.updateArticle(article);
        return "1";
    }
    @PostMapping("/deliverArticle")
    public String deliverArticle(@RequestBody Article article){
        articleService.insertArticle(article);
        return "1";
    }
    @PostMapping("/deleteArticle")
    public String deleteArticle(@RequestBody JSONObject jsonObject,HttpSession session){
        if(!session.getAttribute("username").equals(articleService.getArticle((Integer) jsonObject.get("id")).getAuthor())){
            return "2";
        }
        articleService.deleteArticle((Integer) jsonObject.get("id"));
        return "1";
    }
}
