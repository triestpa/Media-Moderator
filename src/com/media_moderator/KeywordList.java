package com.media_moderator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.media_moderator.R;
import com.media_moderator.article_data.IndividualKeyword;

public class KeywordList extends Activity {
	
	public static final String EXTRA_KEYWORD = "KEYWORD";

	public ListAdapter mAdapter;
	// public List<IndividualKeyword> mData = new
	// ArrayList<IndividualKeyword>();
	public List<String> mData = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_keyword_list);
		ListView lv = (ListView) findViewById(R.id.listView);

		IndividualKeyword key1 = new IndividualKeyword("fuck", "86.0", "positive");
		IndividualKeyword key2 = new IndividualKeyword("bitches", "64.0",
				"negative");
		IndividualKeyword key3 = new IndividualKeyword("get", "13.0", "mixed");
		IndividualKeyword key4 = new IndividualKeyword("money", "70.0", "neutral");

		mData.add(key1.getWord());
		mData.add(key2.getWord());
		mData.add(key3.getWord());
		mData.add(key4.getWord());

		// mAdapter = new KeywordListAdapter(this,
		// R.layout.keywords_row, mData);

		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mData);

		lv.setAdapter(mAdapter);
		// setListAdapter(mAdapter);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentAdapter, View view,
					int position, long id) {
				TextView clickedview = (TextView) view;
				String keyword = (String) clickedview.getText();
				toArticleList(keyword);
			}
		});
	}
	
	protected void toArticleList(String keyword){
		// begin keyword detail view
		// search make list of all articles with keyword(bundle)
		// pass list as intent to next activity(ArticleListActivity)
		Intent intent = new Intent(this, ArticleListActivity.class);
		intent.putExtra(EXTRA_KEYWORD, keyword);
		startActivity(intent);
	}
}