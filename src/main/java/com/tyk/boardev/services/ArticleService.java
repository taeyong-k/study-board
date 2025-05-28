package com.tyk.boardev.services;

import com.tyk.boardev.entities.ArticleEntity;
import com.tyk.boardev.mappers.ArticleMapper;
import com.tyk.boardev.results.ArticleResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleService {
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public static boolean isContentValid(String input) {
        return input != null && input.matches("^(.{1,100000})$");
    }

    public static boolean isTitleValid(String input) {
        return input != null && input.matches("^(.{1,100})$");
    }

    public static boolean isNicknameValid(String input) {
        return input != null && input.matches("^([\\da-zA-Z가-힣]{2,10})$");
    }

    public static boolean isPasswordValid(String input) {
        return input != null && input.matches("^([\\da-zA-Z`~!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:'\",<.>/?]{4,25})$");
    }

    public ArticleResult write(ArticleEntity article) {
        if (article == null ||
                article.isDeleted() ||
                !ArticleService.isNicknameValid(article.getNickname()) ||
                !ArticleService.isPasswordValid(article.getPassword()) ||
                !ArticleService.isTitleValid(article.getTitle()) ||
                !ArticleService.isContentValid(article.getContent())) {
            return ArticleResult.FAILURE;
        }
        article.setNickname(article.getNickname());
        article.setPassword(article.getPassword());
        article.setTitle(article.getTitle());
        article.setContent(article.getContent());
        article.setView(0);
        article.setCreatedAt(LocalDateTime.now());
        article.setDeleted(false);
        return this.articleMapper.insert(article) > 0
                ? ArticleResult.SUCCESS
                : ArticleResult.FAILURE;
    }

    public ArticleEntity getById(int id) {
        if (id < 1) {
            return null;
        }
        return this.articleMapper.selectById(id);
    }

    public ArticleResult incrementView(ArticleEntity article) {
        if (article == null || article.getId() < 1) {
            return ArticleResult.FAILURE;
        }
        article.setView(article.getView() + 1);
        return this.articleMapper.update(article) > 0
                ? ArticleResult.SUCCESS
                : ArticleResult.FAILURE;
    }

    public ArticleResult delete(int id, String password) {
        if (id < 1 || password == null || password.isEmpty()) {
            return ArticleResult.FAILURE;
        }
        ArticleEntity dbArticle = this.articleMapper.selectById(id);
        if (dbArticle == null || dbArticle.isDeleted()) {
            return ArticleResult.FAILURE;
        }
        if (!dbArticle.getPassword().equals(password)) {
            return ArticleResult.FAILURE;
        }
        dbArticle.setDeleted(true);
        return this.articleMapper.update(dbArticle) > 0
                ? ArticleResult.SUCCESS
                : ArticleResult.FAILURE;
    }


}
