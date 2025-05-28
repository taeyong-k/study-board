package com.tyk.boardev.mappers;

import com.tyk.boardev.entities.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    int update(@Param(value = "article") ArticleEntity article);

    int insert(@Param(value = "article") ArticleEntity article);

    ArticleEntity selectById(@Param(value = "id") int id);
}