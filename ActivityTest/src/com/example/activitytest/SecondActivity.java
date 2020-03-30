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
		//�����־������¼standard\singleTop\singleTask����ģʽ��
//		Log.d("SecondActivity",this.toString());
		
		//�����־������¼singleInstance����ģʽ��
		Log.d("SecondActivity","Task id is "+getTaskId());
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		//�������д������FirstActivity�����ť֮����SecondActivity�д�������
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data");
//		Log.d("SecondActivity",data);
		
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//����ļ�����������ʾ�رոû�����FirstActivity���лش�����
//				Intent intent = new Intent();
//				intent.putExtra("data_return","Hello ,FirstActivity");
//				setResult(RESULT_OK,intent);
//				finish();
				
				//�����ť������һ�����������ʾsingleTop����ģʽ
//				Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
//				startActivity(intent);
				
				//����������ʾsingleInstance����ģʽ��
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	//����������д�����ؼ���������ܣ������ǵ�����ؼ���ʱ��������Ȼ�������һ������д��ݷ�������
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return","Hello FirstActivity");
		setResult(RESULT_OK,intent);
		finish();
		
	}
	//�������ٷ���������singleTask��ջ��ʱ���������õĻ
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
