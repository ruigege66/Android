package com.example.activitytest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("BaseActivity",getClass().getSimpleName());
		//下面的代码是用于想要退出程序的时候调用，可以达到直接关闭的作用
		ActivityCollector.addActivity(this);
		
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}

