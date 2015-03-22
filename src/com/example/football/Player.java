package com.example.football;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Player extends Activity {
	private DatabaseAdapter db;
	public ArrayList<String> myList;
	public ListView listview;
	public TextView playerName;
	public TextView goals;
	public TextView lineups;
	public TextView yellows;
	public TextView reds;
	public TextView ages;
	public TextView kits;
	public TextView countries;
	public TextView positions;
	public ImageView imageView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_player);
	    
	    db = new DatabaseAdapter(this);
	    
	    Bundle extras = getIntent().getExtras();
		int tid = extras.getInt(TeamPlayers.EXTRA_TNAME2);
		String pName = extras.getString(TeamPlayers.EXTRA_PNAME);
	    
		String img = getLogo(tid);
		int resID = getResources().getIdentifier(img , "drawable", getPackageName());
		
		imageView = (ImageView) findViewById(R.id.teamimg2);
		imageView.setImageResource(resID);
		
		playerName = (TextView) findViewById(R.id.playername);
		playerName.setText(pName);
		
		goals = (TextView) findViewById(R.id.goalCount);
		lineups = (TextView) findViewById(R.id.lineupCount);
		yellows = (TextView) findViewById(R.id.yellowCount);
		reds = (TextView) findViewById(R.id.redCount);
		ages = (TextView) findViewById(R.id.ageCount);
		kits = (TextView) findViewById(R.id.kitNum);
		countries = (TextView) findViewById(R.id.countryView);
		positions = (TextView) findViewById(R.id.positionView);
		
		db.open();
		Cursor c = db.getParticularPlayer(tid, pName);
		if (c.moveToFirst()) {
			do {
				goals.setText(c.getString(0));
				lineups.setText(c.getString(1));
				yellows.setText(c.getString(2));
				reds.setText(c.getString(3));
				ages.setText(c.getString(4));
				kits.setText(c.getString(6));
				countries.setText(c.getString(5));
				positions.setText(c.getString(7));
			} while (c.moveToNext());
		}
		db.close();
		
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
}
