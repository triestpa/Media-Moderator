package com.media_moderator.article_data;

public class Keyword {
	protected String word;
	protected String relevence;
	protected String sentiment;
	
    protected Keyword(String word, String relevence, String sentiment) {
        this.word = word;
        this.relevence = relevence;
        this.sentiment = sentiment;
    }
    
}
