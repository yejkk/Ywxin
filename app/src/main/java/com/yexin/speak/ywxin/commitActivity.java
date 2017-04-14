package com.yexin.speak.ywxin;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yexin.speak.Adapter.CommitAdapter;
import com.yexin.speak.Log.LogOut;

import java.util.ArrayList;
import java.util.List;

public class commitActivity extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener<PullToRefreshListView> {

    private final String TAG="commitActivity";
    private PullToRefreshListView mPullToRefreshListView;

    private CommitAdapter mCommitAdapter;
    ArrayList<ListData> mList;

    public class ListData {
        public ImageView mImageView;
        public String title;
        public String scroolText;
        public LinearLayout mLinearLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogOut.i(TAG,"commitActivity create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit);
        initView();
        initSetting();
    }

    @Override
    protected  void onStart(){
        LogOut.i(TAG,"commitActivity start");
        super.onStart();
    }
    @Override
    protected  void onStop(){
        LogOut.i(TAG,"commitActivity stop");
        super.onStop();
    }

    @Override
    protected  void onResume(){
        LogOut.i(TAG,"commitActivity onResume");
        super.onResume();
    }
    @Override
    protected  void onDestroy(){
        LogOut.i(TAG,"commitActivity onDestroy");
        super.onDestroy();
    }


    private void initView() {
        mPullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_listView);
         mList = new ArrayList<ListData>();
        for (int i = 0; i <= 10; i++) {
            ListData mListData = new ListData();
            mListData.scroolText = "价格是胃癌的马萨等你撒电话费拉我IE韩国发空间按四个房间";
            mListData.title = "标题";
            mList.add(mListData);
        }
        mCommitAdapter = new CommitAdapter(getApplicationContext(), mList);
        mPullToRefreshListView.setAdapter(mCommitAdapter);

    }

    private void initSetting() {
        mPullToRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {

            @Override
            public void onLastItemVisible() {
                Toast.makeText(commitActivity.this, "End of List!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRefresh(final PullToRefreshBase<PullToRefreshListView> refreshView) {

        String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
        mCommitAdapter = new CommitAdapter(getApplicationContext(), mList);
        refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
        new GetDataTask().execute();
    }


    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            ListData mListData = new ListData();
            mListData.scroolText = "yxin1";
            mListData.title = "叶欣1";
            mList.add(0,mListData);
            mCommitAdapter.notifyDataSetChanged();

            // Call onRefreshComplete when the list has been refreshed.
            mPullToRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
        private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
                "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
                "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
                "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
                "Allgauer Emmentaler" };
    }


}
