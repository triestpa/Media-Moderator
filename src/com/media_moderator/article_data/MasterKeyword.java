package com.media_moderator.article_data;

import java.util.ArrayList;

public class MasterKeyword {
	
	public static ArrayList<MasterKeyword> masterKeywordList;
	protected String word;
	protected double relevanceScore;
	protected ArrayList<Quotation> quotations;
	protected ArrayList<Article> relevantArticles;
    protected ArrayList<Quotation> relevantQuotations;
	
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
			for(Quotation q: newArticle.relevantQuotations) masterKeywordList.get(wordIndex).relevantQuotations.add(q);
			masterKeywordList.get(wordIndex).relevantArticles.add(newArticle);
		}
	}
	
	public MasterKeyword(IndividualKeyword newKeyword){
		this.word = newKeyword.word;
		relevanceScore = 0;
		quotations = new ArrayList<Quotation>();
		relevantArticles = new ArrayList<Article>();
	}
}
