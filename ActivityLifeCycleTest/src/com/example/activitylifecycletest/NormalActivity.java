package com.example.activitylifecycletest;

import android.app.Activity;
//import android.content.Intent;
//import android.net.Uri;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.Window;
//import android.widget.Button;
//import android.widget.Toast;
//import android.view.View;
//import android.view.View.OnClickListener;
import android.util.Log;

public class NormalActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.normal_layout);
		
	}

}
