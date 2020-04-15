package com.example.uibestpractice;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;
import java.util.*;

public class MainActivity extends Activity {
	
	private ListView msgListView;
	
	private EditText inputText;
	
	private Button send;
	
	private MsgAdapter adapter;
	
	private List<Msg> msgList= new ArrayList<Msg>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initMsgs();//��ʼ����Ϣ����
		adapter = new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if(!"".contentEquals(content)) {
					Msg msg = new Msg(content,Msg.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyDataSetChanged();//��������Ϣʱ��ˢ��ListView�е���ʾ
					msgListView.setSelection(msgList.size());//��ListView��λ�����һ��
					inputText.setText("");//���������е�����
				}
			}
		});		
	}
	private void initMsgs() {
		Msg msg1 = new Msg("Hello guy.",Msg.TYPE_RECEICED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello. Who id that",Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3 = new Msg("jsdlf",Msg.TYPE_RECEICED);
		msgList.add(msg3);		
	}
}
