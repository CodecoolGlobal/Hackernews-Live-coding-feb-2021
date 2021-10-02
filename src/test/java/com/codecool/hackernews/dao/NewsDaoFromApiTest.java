package com.codecool.hackernews.dao;

import com.codecool.hackernews.model.News;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsDaoFromApiTest {

    @Test
    public void test() {
        NewsDao newsDao = new NewsDaoFromApi();

        List<News> news = newsDao.read(1);

        System.out.println(news);
    }

}