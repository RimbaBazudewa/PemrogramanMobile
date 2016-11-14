package com.WayanRimbaBazudewa.dompet;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	public static ArrayList<String> str = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str.add("+ 01/10/2016 Kiriman Ortu");
        str.add("- 01/10/2016 Beli Makanan");
        str.add("- 02/10/2016 Beli Pulsa");
        str.add("- 03/10/2016 Beli Bensin");
        Button btnH = (Button)findViewById(R.id.button5);
        Button btnT = (Button)findViewById(R.id.button2);
        Button btnA = (Button)findViewById(R.id.button3);
        
        btnH.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GoHistory(v);
			}
		});
		 btnT.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						GoToInput(v);
					}
				});
		 btnA.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					GoToAbout(v);
				}
			});
    }
    
    private void GoHistory(View v){
    	Intent itent = new Intent(this,History.class);
    	startActivity(itent);
    }
    
    private void GoToAbout(View v){
    	Intent itent = new Intent(this,About.class);
    	startActivity(itent);
    }
    private void GoToInput(View v){
    	Intent itent = new Intent(this,InputTransaksi.class);
    	startActivity(itent);
    }
    @Override
    public void onBackPressed(){
    	str.clear();
    	finish();
    }
}
