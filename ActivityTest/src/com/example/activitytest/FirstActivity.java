package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;


public class FirstActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Firstctivity",getClass().getSimpleName());
		//这个日志用来记录standard\singleTop\singleTask启动模式的
//		Log.d("FirstActivity",this.toString());
		
		//这个日志用来记录singleInstance启动模式的
		Log.d("FirstActivity","Task id is "+getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button) findViewById(R.id.button_1);//findViewById传入id，返回一个View对象
		button1.setOnClickListener(new OnClickListener() {//setOnClickListener方法来注册一个监听器
			@Override
			public void onClick(View v) {
				
				//下面一行用于点击按钮的时候会出现提示信息
//				Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
				
				//下面两行是显式intent的使用方式
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				startActivity(intent);
				
				//下面一行演示的是隐式intent使用方式
//				Intent intent = new Intent("com.example.activitytest.ACTION_START");
//				intent.addCategory("com.example.activitytest.MY_CATEGORY");
//				startActivity(intent);
				
				//下面两行就是点击按钮调用系统浏览器
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setData(Uri.parse("http://www.baidu.com"));
//				startActivity(intent);
				
				//下面两行就是在系统中调用拨号界面
//				Intent intent = new Intent(Intent.ACTION_DIAL);
//				intent.setData(Uri.parse("tel:10083"));
//				startActivity(intent);
				
				//启动第一个活动，向SecondActivity中传递数据
//				String data = "Hello SecondActivity";
//				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//				intent.putExtra("extra_data",data);
//				startActivity(intent);
				
				//接受SecondActivity关闭时回传的数据
//				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//				startActivityForResult(intent,1);
				
				//这里就是自动启动自己，用于演示standard启动模式
//				Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//				startActivity(intent);
				
				//下面演示singleInstance启动方式
//				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//				startActivity(intent);
				SecondActivity.actionStart(FirstActivity.this,"data1","data2");
				
				
				
				//点一下这个按钮，不仅可以显示上面那句话，并且还会退出
//				finish();
			}
		});
	}
	public boolean onCreatOptionMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		return true;
	}
	@Override
	//重写系统自带的onActivityResult方法
	//可以看到之前的代码中是没有调用这个函数的，因此，我认为这个重写的方法，就是当有结果返回的时候，系统会自动调用这个放方法
	protected void onActivityResult(int requestCode,int resultCode,Intent data) {
		switch(requestCode) {
		case 1:
			if(resultCode == RESULT_OK) {
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity",returnedData);
			}
			break;
		default:
		}
	}
	//添加onRestart方法，用于singleTask启动模式
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("FirstActivity","onRestart");
	}
	
	
	
	
	
	

	
}
