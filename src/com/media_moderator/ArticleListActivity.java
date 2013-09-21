package com.media_moderator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.media_moderator.R;
import com.media_moderator.article_data.Article;

public class ArticleListActivity extends Activity {
	
	public static List<Article> mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_list);
		
		Intent intent = getIntent();
		String keyword = intent.getStringExtra(KeywordList.EXTRA_KEYWORD);
		
		mData = findArticles(keyword);
		
		ArticleListFragment fragment = new ArticleListFragment();
		
		getFragmentManager().beginTransaction()
		.replace(R.id.article_list_container, fragment).commit();
	}
	
	protected List<Article> findArticles(String keyword) {
		Article a1 = new Article ("title1", "des", "l", "ABC");
		Article a2 = new Article ("title2", "des", "l", "CBS");
		Article a3 = new Article ("title3", "des", "l", "FOX");
		Article a4 = new Article ("title4", "des", "l", "BBC");

		List<Article> articles = new ArrayList<Article>();
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		articles.add(a4);
		
		return articles;
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article_list, menu);
		return true;
	}

}
