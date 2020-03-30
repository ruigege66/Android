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
		
		//���漸��ʹ�õ������������б�дҵ���߼��ģ����ǽ�ʹ��ʵ�ֽӿڵķ�ʽ�����б�дҵ���߼�
//		button.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				//�ڴ˴����ҵ���߼�
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
			//�ڴ����ҵ���߼�
			//�����ť���Ի��editView�����������
//			String inputText = editText.getText().toString();
//			Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
			//չʾͼƬ
//			imageView.setImageResource(R.drawable.ic_launcher);
			
			//��ʾ����ȡ��������
//			if(progressBar.getVisibility() == View.GONE) {
//				progressBar.setVisibility(View.VISIBLE);
//			}else {
//				progressBar.setVisibility(View.GONE);
//			}
			
			//��̬�ĸ��Ľ���������ʾ
//			int progress = progressBar.getProgress();
//			progress = progress + 10;
//			progressBar.setProgress(progress);
			
			//��ӡAlertDialog�Ի��򣨶����ھ�ʾ��
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
			
			
			//������ʾ�������������ʾ�˽���������ô��ʱ����������������
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
