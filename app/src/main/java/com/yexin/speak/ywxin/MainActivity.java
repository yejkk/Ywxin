package com.yexin.speak.ywxin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yexin.speak.Log.LogOut;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogOut.i(TAG,"MainActivity create");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected  void onStart(){
        LogOut.i(TAG,"MainActivity start");
        super.onStart();
    }
    @Override
    protected  void onStop(){
        LogOut.i(TAG,"MainActivity stop");
        super.onStop();
    }

    @Override
    protected  void onResume(){
        LogOut.i(TAG,"MainActivity onResume");
        super.onResume();
    }
    @Override
    protected  void onDestroy(){
        LogOut.i(TAG,"MainActivity onDestroy");
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainmeunu,menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case R.id.yxmain1:
                Toast.makeText(MainActivity.this, "交流", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(getApplicationContext(),commitActivity.class);

                startActivity(mIntent);
                break;
            case R.id.yxmain2:

                Toast.makeText(MainActivity.this, ""+"设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yxmain3:

                Toast.makeText(MainActivity.this, ""+"退出", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yxmain4:

                Toast.makeText(MainActivity.this, ""+"退出", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
//         Toast.makeText(MainActivity.this, ""+item.getItemId(), Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
