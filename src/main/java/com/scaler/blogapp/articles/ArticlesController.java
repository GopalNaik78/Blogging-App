package com.scaler.blogapp.articles;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    @GetMapping("")
    String getArticles(){
        return "get all articles";
    }

    @GetMapping("/{id}")
    String getArticleById(@PathVariable("id") String id){
        return "get article by id " + id;
    }

    @PostMapping("")
    String createArticle(){
        return "create article";
    }
}
