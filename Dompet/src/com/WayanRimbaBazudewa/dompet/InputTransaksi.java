package com.WayanRimbaBazudewa.dompet;

import java.text.SimpleDateFormat;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class InputTransaksi extends Activity {

	private String textSave="";
	private RadioButton rbtn2;
	private RadioButton rbtn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_transaksi);
		
		rbtn1 = (RadioButton)findViewById(R.id.radioButton1);
		rbtn2 = (RadioButton)findViewById(R.id.radioButton2);
		Button simpanbtn  =(Button)findViewById(R.id.button5);
		rbtn1.setChecked(true);
		
		simpanbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Simpan(v);
			}
		});
		EditText dateText = (EditText)findViewById(R.id.editText1);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyy");
		String newDate = formatDate.format(new Date());
		dateText.setText(newDate);
		rbtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				radioButtonClick(v);
			}
		});
		
		rbtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				radioButtonClick(v);
			}
		});
		
	}
	
	private void radioButtonClick(View v){
		
		switch (v.getId()) {
		case R.id.radioButton1:
			
			rbtn2 = (RadioButton)findViewById(R.id.radioButton2);
			rbtn2.setChecked(false);
			
			break;
		case  R.id.radioButton2:
			rbtn1 = (RadioButton)findViewById(R.id.radioButton1);
			rbtn1.setChecked(false);
			break;
		default:
			break;
		}
		
	}
	
	private void Simpan(View v){
		EditText dateText = (EditText)findViewById(R.id.editText1);
		EditText amount = (EditText)findViewById(R.id.editText2);
		EditText Keterangan = (EditText)findViewById(R.id.editText3);
		String sa = amount.getText().toString() ;
		String kt = Keterangan.getText().toString();
		if(rbtn1.isChecked())
		{
			textSave ="+";
		}else if(rbtn2.isChecked()){
			
			textSave ="-";
		}
		if(!sa.matches("")&&  !kt.matches("") )
		{
			MainActivity.str.add( textSave+dateText.getText().toString() + " " +Keterangan.getText().toString());
			finish();
		}else
		{
			AlertDialog.Builder message1 = new AlertDialog.Builder(this);
			message1.setMessage("amount  dan Keterangan masih kosong  ");
			message1.setCancelable(true);
			message1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			AlertDialog warning = message1.create();
			warning.show();
		}
		
	}
}
