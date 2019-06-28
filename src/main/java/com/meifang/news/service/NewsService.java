package com.meifang.news.service;

import com.meifang.news.dao.domain.News;

import java.util.List;

public interface NewsService {
    boolean insert(News article);

    List<News> getNews();

}
