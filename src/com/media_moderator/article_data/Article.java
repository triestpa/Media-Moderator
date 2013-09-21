package com.media_moderator.article_data;

public class Article {
    public final String title;
    public final String link;
    public final String summary;
    public final String source;

    Article(String title, String summary, String link, String source) {
        this.title = title;
        this.summary = summary;
        this.link = link;
        this.source = source;

        
    }
}