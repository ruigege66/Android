package com.example.uiwidgettest;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button button;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button);
		
		//下面几行使用的匿名类来进行编写业务逻辑的，我们将使用实现接口的方式来进行编写业务逻辑
//		button.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				//在此处添加业务逻辑
//			}
//		});
		
		editText = (EditText)findViewById(R.id.edit_text);
		imageView = (ImageView)findViewById(R.id.image_view);
		
		button.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button:
			//在此添加业务逻辑
			//点击按钮可以获得editView的输入的文字
//			String inputText = editText.getText().toString();
//			Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
			//展示图片
//			imageView.setImageResource(R.drawable.ic_launcher);
			
			//显示或者取消进度条
//			if(progressBar.getVisibility() == View.GONE) {
//				progressBar.setVisibility(View.VISIBLE);
//			}else {
//				progressBar.setVisibility(View.GONE);
//			}
			
			//动态的更改进度条的显示
//			int progress = progressBar.getProgress();
//			progress = progress + 10;
//			progressBar.setProgress(progress);
			
			//打印AlertDialog对话框（多用于警示）
//			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//			dialog.setTitle("This is a dialog");
//			dialog.setMessage("Something important.");
//			dialog.setCancelable(true);
//			dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface dialog,int which) {
//					
//				}
//			});
//			dialog.setNegativeButton("Cancle",new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface dialog,int which) {
//					
//				}
//			});
//			dialog.show();
			
			
			//用于显示进度条，如果显示了进度条，那么暂时还不能做其他操作
			ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setTitle("This is a ProgressDialog");
			progressDialog.setMessage("Loading....");
			progressDialog.setCancelable(true);
			progressDialog.show();
			
			
			break;
		 
		default:
			break;
		}
	}
	
	

}
