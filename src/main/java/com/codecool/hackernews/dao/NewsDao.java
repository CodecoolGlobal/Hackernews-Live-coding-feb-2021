package com.codecool.hackernews.dao;

import com.codecool.hackernews.model.News;

import java.util.List;

public interface NewsDao {
    List<News> read(String endpoint, int page);
}
