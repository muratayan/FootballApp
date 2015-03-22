package com.example.football;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TeamPlayers extends Activity {
	public final static String EXTRA_TNAME2 = "com.example.football.TNAME";
	public final static String EXTRA_PNAME = "com.example.football.PNAME";
	private DatabaseAdapter db;
	public ArrayList<String> myList;
	public ListView listview;
	public TextView textview;
	public ImageView imageView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_teamplayers);
	    
	    db = new DatabaseAdapter(this);
		myList = new ArrayList<String>();
		
		Bundle extras = getIntent().getExtras();
		String tname = extras.getString(Teams.EXTRA_TNAME);
		int tid = extras.getInt(Teams.EXTRA_TID);
		String img = getLogo(tid); // Find associated team logo id from database
		
		final int tid2 = tid;
		// Make it to the image view
		int resID = getResources().getIdentifier(img , "drawable", getPackageName());
		
		imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(resID);
		
		textview = (TextView) findViewById(R.id.teamname);
		textview.setText(tname);
		
		getAllPlayers(tid);
		
		listview = (ListView) findViewById(R.id.playerListforTeam);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, myList);

		listview.setAdapter(adapter);
		
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
			   			    
			    String selectedFromList =(listview.getItemAtPosition(position).toString());
			    Intent intent = new Intent(view.getContext(), Player.class);
			    
			    String pName = selectedFromList.substring(selectedFromList.indexOf('-'));
			    pName = pName.substring(2, pName.length()-5);
			    
			    /*Toast.makeText(TeamPlayers.this,
						pName, Toast.LENGTH_SHORT).show();*/
			    
			    intent.putExtra(EXTRA_TNAME2, tid2);
			    intent.putExtra(EXTRA_PNAME, pName);
			    
				startActivityForResult(intent, 1);
			  }
			}); 
		
		
		
		
	    // TODO Auto-generated method stub
	}
	
	public String getLogo(int tid) {
		db.open();
		Cursor c = db.getLogo(tid);
		if (c.moveToFirst()) {
				String img = c.getString(2);
				db.close();
				return img;
		}else
		{
			String img = "ic_launcher";
			db.close();
			return img;
		}
	}
	
	public void getAllPlayers(int tid) {
		db.open();
		Cursor c = db.getTeamPlayers(tid);
		if (c.moveToFirst()) {
			do {
				DisplayPlayer(c);
			} while (c.moveToNext());
		}
		db.close();
	}
	
	public void DisplayPlayer(Cursor c) {
		
		int kit = c.getInt(0);
		String name = c.getString(1);
		String position = c.getString(2);
		String player = Integer.toString(kit) + " - " + name + " (" + position + ")";
		myList.add(player);
	}

}
