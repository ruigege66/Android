package com.example.listviewtest;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FruitAdapter extends ArrayAdapter<Fruit> {
	
	
	
	private int resourceId;
	
	public FruitAdapter(Context context,int textViewResourceId,List<Fruit> objects) {
		super(context,textViewResourceId,objects);
		resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent) {
		Fruit fruit = getItem(position);//获取当前项的Fruit实例
//		View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
		//上面我们注释掉一个View实例，我们下一行先初始化一个View实例
		View view;
		ViewHolder viewHolder;
		if(convertView == null) {//如果这个View不存在的话，我们就直接建一个View
			view = LayoutInflater.from(getContext()).inflate(resourceId,null);
			viewHolder = new ViewHolder();
			viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
			viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
			view.setTag(viewHolder);//将ViewHolder存储在View中
			
		}else {
			view = convertView;//如果View已经存在了，那么我们就复用已经存在了的View,这样就可以避免再次重新生成View,节省了运行时间
			viewHolder = (ViewHolder) view.getTag();//调用getTag方法，把ViewHolder重新取出。
		}
		//这里我们建立了一个内部类，用来存储已经生成了的fruitImage和fruieName的实例，就省的每次都需要通过findViewById的方法，来去内存中查找目标实例
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitName.setText(fruit.getName());

//		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//		fruitImage.setImageResource(fruit.getImageId());
//		fruitName.setText(fruit.getName());
		return view;
		
	}
	class ViewHolder{
		ImageView fruitImage;
		
		TextView fruitName;
	}
}

