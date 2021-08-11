package com.example.activitytest;
import android.view.Window;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
public class ThirdActivity extends BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("ThirdActivity",getClass().getSimpleName());
		Log.d("ThridActivity","Task id is "+getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		
		//以下代码通过点击按钮来直接退出程序，而不需要点击返回键三次才能退出程序
		Button button3 = (Button)findViewById(R.id.button_3);
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityCollector.finishAll();
			}
		});
	}
	
	

}
