package com.yexin.speak.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yexin.speak.view.AutoScroolTextView;
import com.yexin.speak.ywxin.R;
import com.yexin.speak.ywxin.commitActivity;

import java.util.List;

/**
 * Created by userd on 2016/11/11.
 */
public class CommitAdapter extends BaseAdapter {

    private Context mContext;
    private List<commitActivity.ListData> mListData;
    public CommitAdapter(Context context, List<commitActivity.ListData> nList){
        mContext = context;
        mListData=nList;
    }
    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Context getContext(){
        return mContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        commitActivity.ListData mData = mListData.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.commitlistviewdata,null);
            mViewHolder = new ViewHolder();
            mViewHolder.textView1 =(TextView) convertView.findViewById(R.id.textview1);
            mViewHolder.textView2 =(TextView) convertView.findViewById(R.id.textview2);
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.textView1.setText(mData.title);
        mViewHolder.textView2.setText(mData.scroolText);
       /* mViewHolder.textView2.init();
        if(position != 1){
            mViewHolder.textView2.setScrollSpeed(10);
        }else {
            mViewHolder.textView2.setScrollSpeed(7);
        }
        mViewHolder.textView2.startWork();*/
        return convertView;

    }


    class ViewHolder{
        TextView textView1;
        TextView textView2;

    }
}
