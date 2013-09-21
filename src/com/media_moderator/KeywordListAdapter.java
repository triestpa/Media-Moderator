package com.media_moderator;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.media_moderator.R;
import com.media_moderator.article_data.IndividualKeyword;

//fuck this. wont work, will go with generic for now
public class KeywordListAdapter extends ArrayAdapter<IndividualKeyword> {
	
	private Context mActivity;
	private List<IndividualKeyword> mData;

	public KeywordListAdapter(Context a, int layoutId, List<IndividualKeyword> data) {
		super(a, layoutId);
		mActivity = a;
		mData = data;
	}

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) mActivity
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.keywords_row, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.keywordText);
	    textView.setText(mData.get(position).getWord());
	    
	    return rowView;
	  }
	  /*
	   * 
	private class ViewHolder {
		TextView IndividualKeyword;
		}
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater li = mActivity.getLayoutInflater();
			View convertView = li.inflate(R.layout.keywords_row, parent, false);

			holder = new ViewHolder();
			holder.IndividualKeyword = (TextView) convertView
					.findViewById(R.id.keywordText);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final IndividualKeyword a = mData.get(position);

		if (a != null) {
			holder.IndividualKeyword.setText(a.getWord());
			holder.IndividualKeyword.setPadding(3, 3, 3, 3);
		}
		

		return convertView;
	}
	*/

}
