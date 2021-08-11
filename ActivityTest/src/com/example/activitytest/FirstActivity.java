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
		//�����־������¼standard\singleTop\singleTask����ģʽ��
//		Log.d("FirstActivity",this.toString());
		
		//�����־������¼singleInstance����ģʽ��
		Log.d("FirstActivity","Task id is "+getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button) findViewById(R.id.button_1);//findViewById����id������һ��View����
		button1.setOnClickListener(new OnClickListener() {//setOnClickListener������ע��һ��������
			@Override
			public void onClick(View v) {
				
				//����һ�����ڵ����ť��ʱ��������ʾ��Ϣ
//				Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
				
				//������������ʽintent��ʹ�÷�ʽ
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				startActivity(intent);
				
				//����һ����ʾ������ʽintentʹ�÷�ʽ
//				Intent intent = new Intent("com.example.activitytest.ACTION_START");
//				intent.addCategory("com.example.activitytest.MY_CATEGORY");
//				startActivity(intent);
				
				//�������о��ǵ����ť����ϵͳ�����
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setData(Uri.parse("http://www.baidu.com"));
//				startActivity(intent);
				
				//�������о�����ϵͳ�е��ò��Ž���
//				Intent intent = new Intent(Intent.ACTION_DIAL);
//				intent.setData(Uri.parse("tel:10083"));
//				startActivity(intent);
				
				//������һ�������SecondActivity�д�������
//				String data = "Hello SecondActivity";
//				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//				intent.putExtra("extra_data",data);
//				startActivity(intent);
				
				//����SecondActivity�ر�ʱ�ش�������
//				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//				startActivityForResult(intent,1);
				
				//��������Զ������Լ���������ʾstandard����ģʽ
//				Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//				startActivity(intent);
				
				//������ʾsingleInstance������ʽ
//				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//				startActivity(intent);
				SecondActivity.actionStart(FirstActivity.this,"data1","data2");
				
				
				
				//��һ�������ť������������ʾ�����Ǿ仰�����һ����˳�
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
	//��дϵͳ�Դ���onActivityResult����
	//���Կ���֮ǰ�Ĵ�������û�е�����������ģ���ˣ�����Ϊ�����д�ķ��������ǵ��н�����ص�ʱ��ϵͳ���Զ���������ŷ���
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
	//���onRestart����������singleTask����ģʽ
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("FirstActivity","onRestart");
	}
	
	
	
	
	
	

	
}
