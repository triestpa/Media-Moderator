package com.media_moderator;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.media_moderator.article_data.Article;
import com.media_moderator.article_data.Article_Parser;

public class Article_Retrieval extends Activity{
	public static final String WIFI = "Wi-Fi";
	public static final String ANY = "Any";

	// Whether the display should be refreshed.
	public static boolean refreshDisplay = true;
	public static String sPref = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		String link = intent.getStringExtra(MainActivity.EXTRA_FEED);

		new DownloadXmlTask().execute(link);

	}

	// Implementation of AsyncTask used to download XML feed
	private class DownloadXmlTask extends AsyncTask<String, Void, List<Article>> {
		@Override
		protected List<Article> doInBackground(String... urls) {
			try {
				return loadXmlFromNetwork(urls[0]);
			} catch (IOException e) {
				e.printStackTrace();
				Log.e("article_retrieval", "IO error!");
				return null;
			} catch (XmlPullParserException e) {
				e.printStackTrace();
				Log.e("article_retrieval", "IO error!");
				return null;
			}
		}

		@Override
		protected void onPostExecute(List<Article> result) {
			//do something with list of articles
		}
	}

	// Uploads XML from stackoverflow.com, parses it, and combines it with
	// HTML markup. Returns HTML string.
	@SuppressLint("SimpleDateFormat")
	private List<Article> loadXmlFromNetwork(String urlString)
			throws XmlPullParserException, IOException {
		InputStream stream = null;
		// Instantiate the parser
		Article_Parser article_parse = new Article_Parser();
		List<Article> articles = null;

		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd h:mmaa");

		/*
		 * If I were to spend more time on the app I could add a settings menu
		 * for toggling the summary 
 			SharedPreferences sharedPrefs =
		  	PreferenceManager .getDefaultSharedPreferences(this); boolean pref =
		  	sharedPrefs.getBoolean("summaryPref", false);
		 */

		try {
			stream = downloadUrl(urlString);
			articles = article_parse.parse(stream);
			// Makes sure that the InputStream is closed after the app is
			// finished using it.
		} finally {
			if (stream != null) {
				stream.close();
			}
		}

		return articles;
	}

	// Given a string representation of a URL, sets up a connection and gets
	// an input stream.
	private InputStream downloadUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000 /* milliseconds */);
		conn.setConnectTimeout(15000 /* milliseconds */);
		conn.setRequestMethod("GET");
		conn.setDoInput(true);
		// Starts the query
		conn.connect();
		return conn.getInputStream();
	}

}
