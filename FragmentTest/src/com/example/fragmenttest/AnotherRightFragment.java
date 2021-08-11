package com.example.fragmenttest;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.app.Fragment;

public class AnotherRightFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.annother_right_fragment,container,false);
		return view;
	}
}
