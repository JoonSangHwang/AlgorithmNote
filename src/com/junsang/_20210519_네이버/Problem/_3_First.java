package com.codility.caching;

import org.springframework.stereotype.Service;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;

import org.springframework.cache.annotation.EnableCaching;
//import javax.persistence.Cacheable;
import java.io.IOException;
import com.codility.caching.Article;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * articles 컬렉션을 관리하는 서비스
 * DB에 캐시 계층을 추가하는 CachedArticlesService 클래스를 만드는 작업, 해당 인터페이스 필요하다
 * 4개
 * DB 와 통합을 제공하는 클래스도 제공된다. 다음과 같다
 * 마지막으로 Artice 클래스는 이렇게 구현 되어 있다 (Getter Setter 도 구현 되어 있다)
 */

@Service
@EnableCaching
public class CachingArticlesService implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private CacheManager cacheManager;

    @Override
    //@Cacheable(value="articleId", key="#article.getArticleId()")
    public Article getArticle(Long articleId) {
        Article article = articlesRepository.get(articleId);
        System.out.println("JS 로그 : " + article.getArticleId());

        return article;
    }

    @Override
    //@CacheEvict(value="articleId", key="#article.articleId")
    public void removeArticle(Long articleId) {
        articlesRepository.remove(articleId);

    }

    @Override
    public void saveArticle(Article article) {
        articlesRepository.save(article);

    }

    @Override
    //@CachePut(value = "articleId", key="#article.articleId")
    public Article updateLikes(Long articleId, int likes) {
        Article article = articlesRepository.updateLikes(articleId, likes);
        Long getArticleSeq = article.getArticleId();
        System.out.println("JS 로그2 : " + getArticleSeq);
        return article;
    }
}
