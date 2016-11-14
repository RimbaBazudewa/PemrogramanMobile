package com.WayanRimbaBazudewa.dompet;


import android.app.ListActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;


public class History extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		
		ArrayAdapter listView = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.str);
		setListAdapter(listView);
	}
	
	
}
