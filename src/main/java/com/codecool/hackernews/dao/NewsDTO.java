package com.codecool.hackernews.dao;

import com.codecool.hackernews.model.News;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewsDTO {
    private String title;
    @SerializedName(value = "time_ago")
    private String timeAgo;
    @SerializedName(value = "user")
    private String author;
    private String url;

    public News toNewsObject() {
        return new News(
                title,
                timeAgo,
                author,
                url
        );
    }
}
