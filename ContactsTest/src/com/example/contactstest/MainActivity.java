package com.example.contactstest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView contactsView;
	
	ArrayAdapter<String> adapter;
	
	List<String> contactsList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		contactsView = (ListView) findViewById(R.id.contacts_view);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
		readContacts();
		
	}
	
	private void readContacts() {
		Cursor cursor = null;
		try {
			//查询联系人
			cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
			while(cursor.moveToNext()) {
				//获取联系人
				String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
				String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				contactsList.add(displayName + "\n" + number);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(cursor != null) {
				cursor.close();
			}
		}
	}
}
