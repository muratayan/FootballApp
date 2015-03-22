package com.example.football;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Search extends Activity {
	public final static String EXTRA_SELECTION = "com.example.football.SELECTION";
	public final static String EXTRA_NAME = "com.example.football.NAME";
	public final static String EXTRA_FANCY = "com.example.football.FANCY";
	private RadioGroup radioButtonGroup;
	private RadioButton radioSearchButton;
	private EditText qName;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_search);
	    
	    Button show = (Button) findViewById(R.id.show);
	    show.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){

				radioButtonGroup = (RadioGroup)findViewById(R.id.searchBy);
				int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
				View radioButton = radioButtonGroup.findViewById(radioButtonID);
				int idx = radioButtonGroup.indexOfChild(radioButton);
				
				Intent intent = new Intent(v.getContext(), RadioResult.class);
				intent.putExtra(EXTRA_SELECTION, idx);
				intent.putExtra(EXTRA_NAME, "null");
				intent.putExtra(EXTRA_FANCY, false);
				startActivityForResult(intent, 1);
				
			} 

		});
	    
	    Button searchName = (Button) findViewById(R.id.SearchName);
	    searchName.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){

				qName = (EditText) findViewById(R.id.editText1);
				String pName = qName.getText().toString();
				
				Intent intent = new Intent(v.getContext(), RadioResult.class);
				intent.putExtra(EXTRA_SELECTION, -1);
				intent.putExtra(EXTRA_NAME, pName);
				intent.putExtra(EXTRA_FANCY, false);
				startActivityForResult(intent, 1);
				
			} 

		});
	    
	    Button Fancy = (Button) findViewById(R.id.Fancy);
	    Fancy.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){

				qName = (EditText) findViewById(R.id.editText1);
				String pName = qName.getText().toString();
				
				Intent intent = new Intent(v.getContext(), RadioResult.class);
				intent.putExtra(EXTRA_SELECTION, -1);
				intent.putExtra(EXTRA_NAME, "null");
				intent.putExtra(EXTRA_FANCY, true);
				startActivityForResult(intent, 1);
				
			} 

		});
	    // TODO Auto-generated method stub
	}

}
