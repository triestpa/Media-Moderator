package com.media_moderator.article_data;

import java.util.ArrayList;

public class MasterKeyword {
	
	public static ArrayList<MasterKeyword> masterKeywordList;
	protected String word;
	protected double relevanceScore;
	protected ArrayList<Article> relevantArticles;
	
	public boolean equals(IndividualKeyword compareKeyword){
		return (this.word.equals(compareKeyword.word));
	}
	
	public static void processArticle(Article newArticle) {
		for(IndividualKeyword newWord: newArticle.relevantKeywords){
			if(!masterKeywordList.contains(newWord)){
				new MasterKeyword(newWord);
			}
			int wordIndex = masterKeywordList.indexOf(newWord);
			masterKeywordList.get(wordIndex).relevanceScore += newWord.relevance*newWord.relevance;
			masterKeywordList.get(wordIndex).relevantArticles.add(newArticle);
		}
	}
	
	public MasterKeyword(IndividualKeyword newKeyword){
		this.word = newKeyword.word;
		relevanceScore = 0;
		relevantArticles = new ArrayList<Article>();
	}
}
