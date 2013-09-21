package com.media_moderator.article_data;

public class IndividualKeyword {
	String word;
	double relevance;
	String sentiment;
	
	public IndividualKeyword(String word, String relevance, String sentiment) {
		super();
		this.word = word;
		this.relevance = Double.parseDouble(relevance);
		this.sentiment = sentiment;
	}
	
    public String getWord(){
    	return word;
    }
    public Double getRelevance(){
    	return relevance;
    }
    public String getSentiment(){
    	return sentiment;
    }

}
