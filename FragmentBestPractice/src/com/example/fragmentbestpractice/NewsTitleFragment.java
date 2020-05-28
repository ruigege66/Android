package com.example.fragmentbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsTitleFragment extends Fragment implements OnItemClickListener{
	private ListView newsTitleListView;
	
	private List<News> newsList;
	
	private NewsAdapter adapter;
	
	private boolean isTwoPane;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		newsList = getNews(); //��ʼ����������
		adapter = new NewsAdapter(activity,R.layout.news_item,newsList);
	}
	
	@Override 
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.news_title_frag,container,false);
		newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnItemClickListener(this);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(getActivity().findViewById(R.id.news_content_layout)!= null) {
			isTwoPane = true;//�����ҵ�news_content_layout����ʱ��Ϊ˫ҳģʽ			
		}else {
			isTwoPane = false;//�Ҳ���news_content_layout����ʱ��Ϊ��ҳģʽ
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
		News news = newsList.get(position);
		if(isTwoPane) {
			//�����˫ҳģʽ����ˢ��NewsContentFrayment�е�����
			NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getTitle(),news.getTitle());
		}else {
			//����ǵ�ҳģʽ����ֱ������NewsContentActivity
			NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());	
		}
	}
	private List<News> getNews(){
		List<News> newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setTitle("Succeed in College as a Learning Disabled Student");
		news1.setContent("Collaget freshmen will soon learn to live with roomate,adjust to a new social scene and survive less-than-stellar.");
		News news2 = new News();
		news2.setTitle("Google Android exec poached by China's Xiaomi");
		news2.setContent("China's Xiaomi has poached a key Google executive.");
		newsList.add(news2);
		return newsList;	
	}

}
