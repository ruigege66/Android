package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity{
	
	private SharedPreferences pref;
	
	private Editor editor;
	
	private CheckBox rememberPass;
	
	private EditText accountEdit;
	
	private EditText passwordEdit;
	
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		accountEdit = (EditText)findViewById(R.id.account);
		rememberPass = (CheckBox)findViewById(R.id.remember_pass);
		boolean isRemember = pref.getBoolean("remember_password", false);
		passwordEdit = (EditText)findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		
		if(isRemember) {
			//���˺ź����붼���õ��ı�����
			String account = pref.getString("account", "");
			String password = pref.getString("password", "");
			accountEdit.setText(account);
			passwordEdit.setText(password);
			rememberPass.setChecked(true);
		}
		
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String account =accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();
				//����˺���admin��������12345,����Ϊ��¼�ɹ�
				if(account.equals("admin") && password.equals("12345")) {
					editor = pref.edit();
					if(rememberPass.isChecked()) {
						//��鸴ѡ���Ƿ�ѡ��
						editor.putBoolean("remember_password", true);
						editor.putString("account",account);
						editor.putString("password", password);
					}else {
						editor.clear();
					}
					editor.commit();
					
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}else {
					Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
				}
			}
			
		});
		
	}

}
