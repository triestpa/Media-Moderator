package com.media_moderator;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.media_moderator.R;
import com.media_moderator.article_data.Article;

public class ArticleListAdapter extends ArrayAdapter<Article> {
	private ArticleListActivity mActivity;
	private List<Article> mData;

	public ArticleListAdapter(ArticleListActivity a, int layoutId, List<Article> data) {
		super(a, layoutId, data);
		mActivity = a;
		mData = data;
	}

	private class ViewHolder {
		TextView title;
		TextView source;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater li = mActivity.getLayoutInflater();
			convertView = li.inflate(R.layout.articles_row, parent, false);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.titleText);
			holder.source = (TextView) convertView
					.findViewById(R.id.sourceText);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final Article a = mData.get(position);
		holder.title.setText(a.getTitle());
		holder.source.setText(a.getSource());

		return convertView;
	}
}
