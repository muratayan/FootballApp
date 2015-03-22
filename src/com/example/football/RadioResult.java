package com.example.football;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RadioResult extends Activity {
	private DatabaseAdapter db;
	public ArrayList<String> myList;
	public ArrayList<Integer> myTidList;
	public ListView listview;
	public TextView textview;
	public ImageView imageView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_results);
	    
	    db = new DatabaseAdapter(this);
		myList = new ArrayList<String>();
		myTidList = new ArrayList<Integer>();
		
		Bundle extras = getIntent().getExtras();
		int selection = extras.getInt(Search.EXTRA_SELECTION);
		String qName = extras.getString(Search.EXTRA_NAME);
		boolean f = extras.getBoolean(Search.EXTRA_FANCY);
		int resID = getResources().getIdentifier("ic_launcher" , "drawable", getPackageName());
		
		textview = (TextView) findViewById(R.id.resultName);
		
		if(selection == 0)
		{
			textview.setText("Gol Krallýðý");
			resID = getResources().getIdentifier("soccer", "drawable", getPackageName());
			getPlayersByGoal();
		}else if(selection == 1)
		{
			textview.setText("En Çok Sarý Kart Görenler");
			resID = getResources().getIdentifier("yellow_card" , "drawable", getPackageName());
			getPlayersByYellow();

		}else if(selection == 2)
		{
			getPlayersByRed();
			textview.setText("En Çok Kýrmýzý Kart Görenler");
			resID = getResources().getIdentifier("red_card" , "drawable", getPackageName());
		}else if(selection == 3)
		{
			getPlayersByAge();
			textview.setText("En Yaþlýlar");
		}else if(selection == 4)
		{
			getPlayersByLineup();
			resID = getResources().getIdentifier("lineup" , "drawable", getPackageName());
			textview.setText("En Çok ilk 11 Baþlayanlar");
		}else if(f)
		{
			textview.setText("Ýlk 11 Oynamadan Kart Görenler");
			getFancy();
		}else
		{
			Toast.makeText(RadioResult.this,
					qName, Toast.LENGTH_SHORT).show();
			textview.setText(qName);
			getPlayerByName(qName);
		}
		
		
		imageView = (ImageView) findViewById(R.id.imageViewResult);
		imageView.setImageResource(resID);
		

		listview = (ListView) findViewById(R.id.playerListforResult);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, myList);

		listview.setAdapter(adapter);
		
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
			   			    
			    String selectedFromList =(listview.getItemAtPosition(position).toString());
			    Intent intent = new Intent(view.getContext(), Player.class);
			    			    			    
			    intent.putExtra(TeamPlayers.EXTRA_TNAME2, myTidList.get(position));
			    intent.putExtra(TeamPlayers.EXTRA_PNAME, selectedFromList);
			    
				startActivityForResult(intent, 1);
			  }
			}); 
		
		
		
		
	    // TODO Auto-generated method stub
	}
	
	public void getPlayersByGoal() {
		db.open();
		Cursor c = db.getPlayersByGoal();
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void getPlayersByYellow() {
		db.open();
		Cursor c = db.getPlayersByYellow();
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void getPlayersByRed() {
		db.open();
		Cursor c = db.getPlayersByRed();
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void getPlayersByAge() {
		db.open();
		Cursor c = db.getPlayersByAge();
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void getPlayersByLineup() {
		db.open();
		Cursor c = db.getPlayersByLineup();
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void getPlayerByName(String s) {
		db.open();
		Cursor c = db.getPlayerByName(s);
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void getFancy() {
		db.open();
		Cursor c = db.getFancy();
		if (c.moveToFirst()) {
			DisplayPlayer(c);
			for(int i=0; i<20 && c.moveToNext(); i++) {
				DisplayPlayer(c);
			}
		}
		db.close();
	}
	
	public void DisplayPlayer(Cursor c) {
		
		String pName = c.getString(1);
		int tid = c.getInt(0);
		myList.add(pName);
		myTidList.add(tid);
	}

}