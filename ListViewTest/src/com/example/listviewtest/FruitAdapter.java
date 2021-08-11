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
		Fruit fruit = getItem(position);//��ȡ��ǰ���Fruitʵ��
//		View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
		//��������ע�͵�һ��Viewʵ����������һ���ȳ�ʼ��һ��Viewʵ��
		View view;
		ViewHolder viewHolder;
		if(convertView == null) {//������View�����ڵĻ������Ǿ�ֱ�ӽ�һ��View
			view = LayoutInflater.from(getContext()).inflate(resourceId,null);
			viewHolder = new ViewHolder();
			viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
			viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
			view.setTag(viewHolder);//��ViewHolder�洢��View��
			
		}else {
			view = convertView;//���View�Ѿ������ˣ���ô���Ǿ͸����Ѿ������˵�View,�����Ϳ��Ա����ٴ���������View,��ʡ������ʱ��
			viewHolder = (ViewHolder) view.getTag();//����getTag��������ViewHolder����ȡ����
		}
		//�������ǽ�����һ���ڲ��࣬�����洢�Ѿ������˵�fruitImage��fruieName��ʵ������ʡ��ÿ�ζ���Ҫͨ��findViewById�ķ�������ȥ�ڴ��в���Ŀ��ʵ��
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

