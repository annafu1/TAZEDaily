package com.tazedaily.TAZEDaily.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tazedaily.TAZEDaily.Domain.Genre;
import com.tazedaily.TAZEDaily.Domain.NewsArticle;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {
    NewsArticle findArticleById(Long id);

    Iterable<NewsArticle> findArticlesByGenre(Genre genre);

    @Query(value = "SELECT * FROM news_article order by rand()", nativeQuery = true)
    List<NewsArticle> findRandArticles();
}