package com.media_moderator.article_data;

import java.util.ArrayList;

public class Article {
    protected String title;
    protected String link;
    protected String summary;
    protected String source;
    
    protected ArrayList<IndividualKeyword> relevantKeywords;

    public Article(String title, String summary, String link, String source) {
        this.title = title;
        this.summary = summary;
        this.link = link;
        this.source = source;   
    }
    
    public Article(String title, String summary, String link, String source, IndividualKeyword[] keywords) {
    	this(title, summary, link, source);
    	
    	for (IndividualKeyword i: keywords) this.relevantKeywords.add(i);
    	MasterKeyword.processArticle(this);
    }
    
    public String getTitle(){
    	return title;
    }
    
    public String getLink(){
    	return link;
    }
    
    public String getSummary(){
    	return summary;
    }
    
    public String getSource(){
    	return source;
    }
    
    public ArrayList<IndividualKeyword> getKeywords(){
    	return relevantKeywords;
    }

}
