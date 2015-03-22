package com.example.football;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.example.football.DatabaseAdapter;

import com.example.football.R;

import com.example.football.Teams;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private DatabaseAdapter db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			// If database doesn't exist, create it.
			String destPath = "/data/data/" + getPackageName()
					+ "/databases/MyDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("mydb"),
						new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		db = new DatabaseAdapter(this);
	}

	public void onStart(){
		super.onStart();
		// Two buttons for the starting activity
		// One for the team list;
		// One for the spesific search screen
		Button teamsButton = (Button)findViewById(R.id.teamsButton);
		teamsButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){

				Intent myIntent = new Intent(v.getContext(), Teams.class);
				startActivityForResult(myIntent, 1);
			} 

		});
		
		Button searchButton = (Button)findViewById(R.id.searchButton);
		searchButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){

				Intent myIntent = new Intent(v.getContext(), Search.class);
				startActivityForResult(myIntent, 1);
			} 

		});
	
	}
	
	
	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// ---copy 1K bytes at a time---
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}

}
