package com.example.broadcasttest3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context,Intent intend) {
		Toast.makeText(context, "receive in AnotherBroadcastReceiver",Toast.LENGTH_SHORT).show();
	}
}
