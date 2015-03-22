package com.example.football;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Teams extends Activity {
	public final static String EXTRA_TNAME = "com.example.football.TNAME";
	public final static String EXTRA_TID = "com.example.football.TID";
	private DatabaseAdapter db;
	public ArrayList<String> myList;
	public ListView listview;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_teams);
	    
		// Build up the list from database
	    db = new DatabaseAdapter(this);
		myList = new ArrayList<String>();
		getAllTeams();
		
		// Through the adapter, put them on list view
		listview = (ListView)findViewById(R.id.searchResultsListView);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, myList);

		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
			   			    
				// On click a list item, opens up the team page			
				int tid = position+1;
			    String selectedFromList =(listview.getItemAtPosition(position).toString());
			    
			    
			    Intent intent = new Intent(view.getContext(), TeamPlayers.class);
			    
			    intent.putExtra(EXTRA_TNAME, selectedFromList);
			    intent.putExtra(EXTRA_TID, tid);
			    
				startActivityForResult(intent, 1);
			  }
			}); 
	    
	}
	
	public void getAllTeams() {
		db.open();
		Cursor c = db.getAllTeams();
		if (c.moveToFirst()) {
			do {
				DisplayTeam(c);
			} while (c.moveToNext());
		}
		db.close();
	}

	public void DisplayTeam(Cursor c) {
		
		String team = c.getString(1);
	
		myList.add(team);
	}

}
