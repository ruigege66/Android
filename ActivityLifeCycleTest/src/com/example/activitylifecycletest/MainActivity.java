package com.example.activitylifecycletest;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {
	public static final String TAG="MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG,"onCreate");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		if(savedInstanceState != null){
			String tempData = savedInstanceState.getString("data_key");
			Log.d(TAG,tempData);
		}
		Button startNormalActivity = (Button)findViewById(R.id.start_normal_activity);
		Button startDialogActivity = (Button)findViewById(R.id.start_dialog_activity);
		startNormalActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,NormalActivity.class);
				startActivity(intent);
			}
		});
		startDialogActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,DialogActivity.class);
				startActivity(intent);
			}
		});
		
	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG,"onStart");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG,"onResume");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG,"onPause");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG,"onStop");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG,"onDestroy");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG,"onRestart");
	}
	
	//这个方法就是用来当我们的某一个活动被停止的时候，在它被回收之前，将我们产生的数据进行保存以备恢复数据
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		String tempData = "Something you just typed";
		outState.putString("data_key", tempData);
	}

}
