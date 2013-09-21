package com.media_moderator.article_data;

public class Article {
    protected String title;
    protected String link;
    protected String summary;
    protected String source;
    
    protected Keyword[] keywords;

    protected Article(String title, String summary, String link, String source) {
        this.title = title;
        this.summary = summary;
        this.link = link;
        this.source = source;   
    }
    
    protected Article(String title, String summary, String link, String source, Keyword[] keywords) {
    	this(title, summary, link, source);  
        this.keywords = keywords;
    }
    
    
}