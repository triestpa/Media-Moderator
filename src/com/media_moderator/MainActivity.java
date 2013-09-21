package com.media_moderator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.media_moderator.R;

public class MainActivity extends Activity {

	public static final String EXTRA_FEED = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		readCNN();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void readCNN () {
		String xmlLink = "http://rss.cnn.com/rss/cnn_topstories.xml";

	  	Intent intent = new Intent (this, Article_Pull.class);
    	intent.putExtra(EXTRA_FEED, xmlLink);

    	startActivity(intent);
	}
	
	

}
