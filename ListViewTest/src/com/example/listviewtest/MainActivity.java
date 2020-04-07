package com.example.listviewtest;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.*;
//import java.lang.ArrayAdapter;

public class MainActivity extends Activity {
	
	private List<Fruit> fruitList = new ArrayList<Fruit>();
	
//	private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initFruits();//初始化水果数据
		FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
		
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//				MainActivity.this,android.R.layout.simple_list_item_1,data);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		
		//接下来就来注册点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
				Fruit fruit = fruitList.get(position);
				Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
			}
		});
		
	}
	private void initFruits() {
		Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
		fruitList.add(banana);
		Fruit orange =new Fruit("Orange",R.drawable.orange_pic);
		fruitList.add(orange);
				
	}
}
