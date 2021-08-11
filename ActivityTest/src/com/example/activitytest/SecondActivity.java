package com.example.activitytest;

import android.view.Window;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class SecondActivity extends BaseActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("SecondActivity",getClass().getSimpleName());
		//这个日志用来记录standard\singleTop\singleTask启动模式的
//		Log.d("SecondActivity",this.toString());
		
		//这个日志用来记录singleInstance启动模式的
		Log.d("SecondActivity","Task id is "+getTaskId());
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		//以下三行代表的是FirstActivity点击按钮之后，向SecondActivity中传入数据
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data");
//		Log.d("SecondActivity",data);
		
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//这里的几行是用来演示关闭该活动后会向FirstActivity进行回传数据
//				Intent intent = new Intent();
//				intent.putExtra("data_return","Hello ,FirstActivity");
//				setResult(RESULT_OK,intent);
//				finish();
				
				//点击按钮启动第一个活动，用于演示singleTop启动模式
//				Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
//				startActivity(intent);
				
				//下面用于演示singleInstance启动模式的
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	//在这个活动中重写“返回键”这个功能，当我们点击返回键的时候，我们依然可以向第一个活动进行传递返回数据
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return","Hello FirstActivity");
		setResult(RESULT_OK,intent);
		finish();
		
	}
	//下面销毁方法，用于singleTask弹栈的时候销毁无用的活动
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SecondActivity","onDestroy");
	}
	public static void actionStart(Context context,String data1,String data2) {
		Intent intent = new Intent(context,SecondActivity.class);
		intent.putExtra("param1",data1);
		intent.putExtra("param2",data2);
		context.startActivity(intent);
	}
	

}
