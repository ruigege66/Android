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
		localBroadcastManager = LocalBroadcastManager.getInstance(this);//获取实例
		
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//下面这行代码是用来全局广播的
//				Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
				//下面这行代码是用来本地广播的（也就是app内部传递广播）
				Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
				localBroadcastManager.sendBroadcast(intent);//发送本地广播				
//				sendBroadcast(intent);
				//我们关闭上面一行代码，然后写另一种方法sendOrderedBroadcast,发送有序广播
				sendOrderedBroadcast(intent,null);
			}
		});
		intentFilter = new IntentFilter();
		intentFilter.addAction("com.example.broadcasttest.LOCAL_BROACAST");
		localReceiver = new LocalReceiver();
		localBroadcastManager.registerReceiver(localReceiver,intentFilter);//注册本地广播监听器
		
		
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
