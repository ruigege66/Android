package com.example.broadcasttest2;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private IntentFilter intentFilter;
	
	private LocalReceiver localReceiver;
	
	private LocalBroadcastManager localBroadcastManager;
	
	private NetworkChangeReceiver networkChangeReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intentFilter = new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver = new NetworkChangeReceiver();
		registerReceiver(networkChangeReceiver,intentFilter);
		localBroadcastManager = LocalBroadcastManager.getInstance(this);//��ȡʵ��
		
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//�������д���������ȫ�ֹ㲥��
//				Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
				//�������д������������ع㲥�ģ�Ҳ����app�ڲ����ݹ㲥��
				Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
				localBroadcastManager.sendBroadcast(intent);//���ͱ��ع㲥				
//				sendBroadcast(intent);
				//���ǹر�����һ�д��룬Ȼ��д��һ�ַ���sendOrderedBroadcast,��������㲥
				sendOrderedBroadcast(intent,null);
			}
		});
		intentFilter = new IntentFilter();
		intentFilter.addAction("com.example.broadcasttest.LOCAL_BROACAST");
		localReceiver = new LocalReceiver();
		localBroadcastManager.registerReceiver(localReceiver,intentFilter);//ע�᱾�ع㲥������
		
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
//		unregisterReceiver(networkChangeReceiver);
		localBroadcastManager.unregisterRecerver(localReceiver);
		
	}
	
	class NetworkChangeReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context,Intent intent) {
			ConnectivityManager connectionMananger = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectionMananger.getActiveNetworkInfo();
			if(networkInfo != null && networkInfo.isAvailable()) {
				Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();				
			} else {
				Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
			}
			
		}
	}
	
	class LocalReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context,Intent intent) {
			Toast.makeText(context,"received local broadcast",Toast.LENGTH_SHORT).show();
		}
	}
}