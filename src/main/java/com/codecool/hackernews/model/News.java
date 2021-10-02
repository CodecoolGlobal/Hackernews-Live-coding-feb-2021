package com.codecool.hackernews.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class News {
    private String title;
    private String timeAgo;
    private String author;
    private String url;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", timeAgo='" + timeAgo + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
