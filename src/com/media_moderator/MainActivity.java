package com.media_moderator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.media_moderator.R;

public class MainActivity extends Activity {

	public static final String EXTRA_FEED = "RSS FEED";
	public static final String EXTRA_SOURCE = "NEWS SOURCE";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		readRSS("http://feeds.foxnews.com/foxnews/world", "Fox");
		readRSS("http://rss.cnn.com/rss/cnn_world.rss", "CNN");
		readRSS("http://america.aljazeera.com/content/ajam/articles.rss", "AlJazeera");
		//mod parser to not take videos
		//readRSS("http://feeds.bbci.co.uk/news/rss.xml", "BBC");
		readRSS("http://feeds.nbcnews.com/feeds/topstories", "NCB");
		readRSS("http://rss.nytimes.com/services/xml/rss/nyt/World.xml", "NYT");
		readRSS("http://online.wsj.com/xml/rss/3_7085.xml", "WSJ");		
		readRSS("http://feeds.reuters.com/Reuters/worldNews", "Reuters");
			*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void readRSS(String xmlLink, String source) {

		Intent intent = new Intent(this, Article_Pull.class);
		Bundle extras = new Bundle();
		
		extras.putString(EXTRA_FEED, xmlLink);
		extras.putString(EXTRA_SOURCE, source);
		intent.putExtras(extras);

		startActivity(intent);
	}

}
