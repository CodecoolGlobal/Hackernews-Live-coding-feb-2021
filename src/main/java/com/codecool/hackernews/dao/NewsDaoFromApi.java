package com.codecool.hackernews.dao;

import com.codecool.hackernews.model.News;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoFromApi implements NewsDao {

    private final Gson gson = new Gson();
    private final HackerNewsClient client = new HackerNewsClient();

    @Override
    public List<News> read(String endpoint, int page) {
        String response = client.getJsonResponse(endpoint, page);
        Type type = new TypeToken<List<NewsDTO>>() {
        }.getType();

        List<NewsDTO> news = gson.fromJson(response, type);

        return mapToNews(news);
    }

    private List<News> mapToNews(List<NewsDTO> news) {
        List<News> result = new ArrayList<>();
        for (NewsDTO dto : news) {
            result.add(dto.toNewsObject());
        }
        return result;
    }
}
