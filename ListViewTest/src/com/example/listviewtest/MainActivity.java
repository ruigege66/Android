package com.example.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import java.lang.ArrayAdapter;

public class MainActivity extends Activity {
	private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this,android.R.layout.simple_list_item_1,data);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		
	}
}
