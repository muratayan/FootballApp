package com.example.football;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAdapter {
	public static final String KEY_ROWID = "pid";
	public static final String KEY_ROWID2 = "tid";
	public static final String KEY_TEAMNAME = "teamname";
	public static final String KEY_TIMG = "timg";
	public static final String KEY_KITNUM = "kitnum";
	public static final String KEY_COUNTRY = "country";
	public static final String KEY_NAME = "playername";
	public static final String KEY_POSITION = "position";
	public static final String KEY_AGE = "age";
	public static final String KEY_LINEUP = "lineupcount";    
	public static final String KEY_GOAL = "goal";
	public static final String KEY_YELLOW = "yellowcard";
	public static final String KEY_RED = "redcard";

	private static final String TAG = "DBAdapter";

	private static final String DATABASE_NAME = "MyDB";
	private static final String DATABASE_TABLE = "players";
	private static final String DATABASE_TABLE2 = "teams";
	private static final int DATABASE_VERSION = 1;

	// Team Database
	private static final String DATABASE_CREATE2 = "create table teams (tid integer primary key autoincrement, "
				+ "teamname text not null, timg text);";
	
	// Player Database
	private static final String DATABASE_CREATE = "create table players (pid integer primary key autoincrement, tid integer,"
			+ "kitnum text, country text, playername text not null, position text, age integer, lineupcount integer, goal integer, yellowcard integer, redcard integer);";
	
	private final Context context;

	private DatabaseHelper databaseHelper;
	private SQLiteDatabase db;

	public DatabaseAdapter(Context ctx) {
		this.context = ctx;
		databaseHelper = new DatabaseHelper(context);
	}

	/**
	 * Inner private class for database access and manipulation, extending
	 * SQLiteOpenHelper data type for doing so.
	 * 
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(DATABASE_CREATE);
				db.execSQL(DATABASE_CREATE2);
				
				//Create teams
				db.execSQL("INSERT INTO teams(teamname, timg) values('Akhisarspor', 'akhisar');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Antalyaspor', 'antalya');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Be�ikta�', 'bjk');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Bursaspor', 'bursa');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Elaz��spor', 'elazigspor');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Eski�ehirspor', 'eskisehirspor');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Fenerbah�e', 'fenerbahce');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Galatasaray', 'galatasaray');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Gaziantepspor', 'gaziantepspor');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Gen�lerbirli�i', 'genclerbirligi');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('�stanbul BB', 'istbelediye');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Karab�kspor', 'kardemir');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Kas�mpa�a', 'kasimpasa');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Kayserispor', 'kayserispor');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Mersin �dman Yurdu', 'mersin');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Orduspor', 'orduspor');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Sivasspor', 'sivasspor');");
				db.execSQL("INSERT INTO teams(teamname, timg) values('Trabzonspor', 'trabzonspor');");
				
				/* Creating players */
				
				// Akhisar
				
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','26','T�rkiye','Alican Candemir','GK','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','1','T�rkiye','Emrah Tuncel','GK','25','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','48','T�rkiye','Evren �zyigit','GK','27','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','18','T�rkiye','Oguz Daglaroglu','GK','33','33','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','4','T�rkiye','�agdas Atan','CB','33','30','1','10','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','34','T�rkiye','Emrah Eren','CB','34','33','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','45','T�rkiye','G�khan Din�er','CB','26','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','19','Senegal','Ibrahima Sonko','CB','32','29','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','5','T�rkiye','K�rsat Duymus','CB','34','6','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','3','T�rkiye','Serkan Yal�in','CB','30','5','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','15','T�rkiye','Ugur Demirok','CB','24','26','3','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','20','T�rkiye','Ahmet Cebe','CM','30','15','1','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','95','T�rkiye','Ahmet �i�ek','CM','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','35','T�rkiye','Bilal Kisa','CM','29','13','1','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','30','Brezilya','Diego Lima','CM','24','1','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','14','T�rkiye','Emin Aladag','CM','30','22','1','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','22','T�rkiye','G�ray Vural','CM','24','16','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','6','T�rkiye','Merter Y�ce','CM','28','22','-','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','21','T�rkiye','Mustafa Asan','CM','24','13','2','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','11','T�rkiye','Sertan Vardar','CM','31','26','3','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','80','Brezilya','Bruno Mezenga','ST','24','25','3','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','7','T�rkiye','Kenan �zer','ST','25','19','4','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','99','Avustralya','Kerem Bulut','ST','21','1','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','8','Nijerya','Sani Gideon','ST','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','96','T�rkiye','Serkan Cansoy','ST','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','24','Kamerun','Severin Brice Bikoko ','ST','24','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('1','17','Yunanistan','Theofanis Gekas','ST','32','13','12','-','-');");
				
				// Antalya
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','1','T�rkiye','Hakan Arikan','GK','30','19','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','17','T�rkiye','Polat Keser','GK','27','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','33','Kamerun','Sammy Ndjock','GK','23','13','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','2','T�rkiye','Ali Tandogan','CB','35','10','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','24','T�rkiye','Deniz Baris','CB','35','26','1','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','3','T�rkiye','Emre G�ng�r','CB','28','21','-','9','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','15','T�rkiye','Erg�n Teber','CB','27','23','-','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','51','T�rkiye','Koray Arslan','CB','29','23','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','59','T�rkiye','Mehmet Sedef','CB','25','9','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','7','T�rkiye','Musa Nizam','CB','22','13','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','28','Hirvatistan','Nikola Zizic','CB','25','3','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','11','T�rkiye','Emrah Bassan','CM','21','8','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','4','T�rkiye','Ibrahim Dagasan','CM','28','15','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','6','Fas','Ismail Aissati','CM','24','28','3','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','67','T�rkiye','Mehmet Eren Boyraz','CM','31','3','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','21','T�rkiye','Murat Duruer','CM','25','13','3','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','22','�ek Cumhuriyeti','Petr Janda','CM','26','9','-','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','8','T�rkiye','Ugur Inceman','CM','31','29','3','9','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','18','T�rkiye','Zeki Yildirim','CM','22','4','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','20','Nijerya','Isaac Promise','ST','25','28','8','1','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','26','Senegal','Lamine Diarra','ST','29','32','13','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','77','T�rkiye','�mer Sismanoglu','ST','23','2','7','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('2','25','Kamerun','Xavier Kodjo','ST','18','-','-','-','-');");

				// Besiktas
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','23','Isko�ya','Allan Mcgregor','GK','31','26','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','1','T�rkiye','Cenk G�nen','GK','25','7','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','99','T�rkiye','Emre Metin','GK','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','24','T�rkiye','Emre �zkan','CB','24','7','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','22','T�rkiye','Ersan Adem G�l�m','CB','26','17','1','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','19','T�rkiye','G�khan S�zen','CB','25','10','-','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','5','T�rkiye','Ibrahim Toraman','CB','31','25','3','9','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','3','T�rkiye','Ismail K�ybasi','CB','23','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','14','Fransa','Julien Escude','CB','33','9','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','13','Almanya','Roberto Hilbert','CB','28','31','3','10','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','6','�ek Cumhuriyeti','Tomas Sivok','CB','29','26','5','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','39','T�rkiye','Erkan Kas','CM','21','-','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','30','T�rkiye','Hasan T�rk','CM','20','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','4','Portekiz','Manuel Fernandes','CM','27','26','7','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','28','Almanya','Mehmet Akg�n','CM','26','5','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','80','T�rkiye','Muhammed Demirci','CM','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','20','T�rkiye','Necip Uysal','CM','22','20','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','15','T�rkiye','Oguzhan �zyakup','CM','20','17','2','8','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','10','T�rkiye','Olcay Sahan','CM','25','32','11','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','25','T�rkiye','Ugur Boral','CM','31','16','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','8','Avusturya','Veli Kavlak','CM','24','23','1','8','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','7','Brezilya','Dentinho','ST','24','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','37','Slovakya','Filip Holosko','ST','29','27','10','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','9','Portekiz','Hugo Almeida','ST','28','17','9','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','35','T�rkiye','Koray Yildiz','ST','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','53','Senegal','Mamadou Niang','ST','33','8','3','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','17','T�rkiye','Mehmet Aky�z','ST','27','-','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','11','T�rkiye','Mustafa Pektemek','ST','24','8','2','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('3','26','T�rkiye','Sinan Kurumus','ST','18','1','-','-','-');");

				// Bursaspor
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','88','T�rkiye','Bekir Sevgi','GK','24','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','12','T�rkiye','Harun Tekin','GK','23','4','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','17','Ingiltere','Scott Carson','GK','27','29','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','3','Ingiltere','Anton Ferdinand','CB','28','6','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','6','T�rkiye','G�k�ek Vederson','CB','31','25','-','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','42','T�rkiye','Hakan Aslantas','CB','27','9','-','3','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','38','T�rkiye','Ibrahim �zt�rk','CB','31','31','2','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','20','Fas','Michael Basser','CB','28','22','1','3','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','16','T�rkiye','�mer Erdogan','CB','36','11','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','28','T�rkiye','Ozan Tufan','CB','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','22','T�rkiye','Sener �zbayrakli','CB','23','15','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','23','T�rkiye','Serdar Aziz','CB','22','18','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','39','T�rkiye','Ferhat Kiraz','CM','24','13','4','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','5','Arjantin','Fernando Belluschi','CM','29','28','5','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','26','T�rkiye','Furkan Soyalp','CM','17','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','21','A.B.D.','Maurice Edu','CM','27','10','-','3','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','55','T�rkiye','Murat Yildirim','CM','25','10','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','35','T�rkiye','Musa �agiran','CM','20','13','1','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','10','Arjantin','Pablo Batalla','CM','29','32','15','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','4','T�rkiye','Tuncay Sanli','CM','31','22','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','14','T�rkiye','Okan Deniz','ST','18','2','1','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','11','Sili','Sebastian Pinto','ST','27','24','8','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('4','9','Slovakya','Stanislav Sestak','ST','30','17','7','3','-');");

				// Elaz��
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','91','T�rkiye','M�cahit Atalay','GK','21','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','68','T�rkiye','Tolga �zgen','GK','33','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','1','Hirvatistan','Vanja Ivesa','GK','35','33','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','22','T�rkiye','Adem Alkasi','CB','29','27','-','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','14','T�rkiye','Ahmet G�rkem G�rk','CB','29','8','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','58','Brezilya','Fabio Bilica','CB','34','30','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','27','Hirvatistan','Hrvoje Spahija','CB','25','1','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','71','T�rkiye','Murat Aky�z','CB','31','5','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','4','T�rkiye','Orhan Ak','CB','33','24','-','11','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','61','T�rkiye','Sedat Bayrak','CB','32','22','2','9','3');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','48','T�rkiye','Alper Kalemci','CM','21','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','21','T�rkiye','Aydin Karabulut','CM','25','19','-','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','20','T�rkiye','B�lent Ertugrul','CM','34','15','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','34','T�rkiye','Eren Aydin','CM','31','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','39','Bosna Hersek','Ivan Sesar','CM','23','9','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','11','T�rkiye','K�ksal Yedek','CM','28','33','4','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','90','Hollanda','Marvin Zeegelaar','CM','22','14','-','1','2');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','16','T�rkiye','Mustafa Sarp','CM','32','9','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','40','Hollanda','Roland Alberg','CM','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','67','T�rkiye','Serdar G�rler','CM','21','16','6','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','31','Senegal','Tidiane Sane','CM','27','14','4','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','88','T�rkiye','Volkan Yilmaz','CM','25','-','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','50','Isve�','Emir Kujovic','ST','24','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','19','Ingiltere','Jake Jervis','ST','21','3','1','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','6','T�rkiye','Mehmet �akir','ST','29','2','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('5','17','T�rkiye','Sinan Kaloglu','ST','31','12','6','-','-');");

				// Eskisehir
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','33','T�rkiye','Kayacan Erdogan','GK','25','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','25','Bel�ika','Ruud Boffin','GK','25','32','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','87','T�rkiye','Sinan �ren','GK','25','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','4','Brezilya','Dede','CB','35','30','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','3','Brezilya','Diego Angelo','CB','27','31','3','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','30','Gana','Jerry Akaminko','CB','25','21','1','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','76','T�rkiye','Servet �etin','CB','32','26','2','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','5','T�rkiye','Sezgin Coskun','CB','28','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','22','Azerbaycan','Ufuk Budak','CB','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','6','T�rkiye','Alper Potuk','CM','22','28','3','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','7','Sirbistan','Andrej Mrkela','CM','21','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','35','T�rkiye','Ayta� Kara','CM','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','10','Isve�','Erkan Zengin','CM','27','27','4','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','99','Sirbistan','Goran Causic','CM','21','9','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','50','T�rkiye','H�rriyet G��er','CM','31','29','-','7','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','8','T�rkiye','Mehmet G�ven','CM','25','8','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','80','T�rkiye','Nuri Fatih Aydin','CM','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','14','Sili','Rodrigo Tello','CM','33','24','2','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','17','T�rkiye','Serol Demirhan','CM','24','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','77','Almanya','Tarik �amdal','CM','22','4','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','88','T�rkiye','Veysel Sari','CM','22','24','1','11','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','9','Avusturya','Atdhe Nuhiu','ST','23','6','2','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','15','Senegal','Diomansy Kamara','ST','32','27','10','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('6','20','T�rkiye','Necati Ates','ST','33','26','12','5','-');");

				// Fenerbah�e
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','54','T�rkiye','Erten Ersu','GK','19','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','34','T�rkiye','Fehmi Mert G�nok','GK','24','5','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','85','T�rkiye','Serkan Kirintili','GK','28','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','1','T�rkiye','Volkan Demirel','GK','31','28','-','3','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','4','T�rkiye','Bekir Irteg�n','CB','29','24','1','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','2','T�rkiye','Egemen Korkmaz','CB','30','18','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','77','T�rkiye','G�khan G�n�l','CB','28','26','3','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','3','T�rkiye','Hasan Ali Kaldirim','CB','23','25','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','6','Nijerya','Joseph Yobo','CB','32','20','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','67','T�rkiye','Orhan Sam','CB','26','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','33','Isvi�re','Reto Ziegler','CB','27','6','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','53','T�rkiye','Serdar Kesimal','CB','24','5','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','88','T�rkiye','Caner Erkin','CM','24','13','-','7','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','16','Brezilya','Cristian Baroni','CM','29','23','5','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','11','Hollanda','Dirk Kuyt','CM','32','29','8','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','25','T�rkiye','Emre Bel�zoglu','CM','32','9','2','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','5','T�rkiye','Mehmet Topal','CM','27','23','3','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','38','T�rkiye','Mehmet Topuz','CM','29','11','-','1','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','27','Sirbistan','Milos Krasic','CM','28','6','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','9','Slovakya','Miroslav Stoch','CM','23','10','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','14','Portekiz','Raul Meireles','CM','30','22','2','7','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','17','T�rkiye','Recep Niyaz','CM','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','48','T�rkiye','Salih U�an','CM','19','4','3','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','21','T�rkiye','Sel�uk Sahin','CM','32','7','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','20','T�rkiye','Sezer �zt�rk','CM','27','1','2','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','28','T�rkiye','Beykan Simsek','ST','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','7','Senegal','Moussa Sow','ST','27','27','15','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','99','Kamerun','Pierre Webo','ST','31','12','6','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('7','23','T�rkiye','Semih Sent�rk','ST','30','1','1','3','-');");

				// Galatasaray
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','82','T�rkiye','Aykut Er�etin','GK','30','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','67','T�rkiye','Eray Iscan','GK','21','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','25','Uruguay','Fernando Muslera','GK','26','32','-','2','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','86','T�rkiye','Ufuk Ceylan','GK','26','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','33','T�rkiye','�aglar Birinci','CB','27','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','13','Kamerun','Dany Nounkeu','CB','27','23','-','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','27','Fildisi Sahili','Emmanuel Eboue','CB','29','25','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','5','T�rkiye','G�khan Zan','CB','31','9','-','3','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','22','T�rkiye','Hakan Balta','CB','30','12','1','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','55','T�rkiye','Sabri Sarioglu','CB','28','8','-','1','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','26','T�rkiye','Semih Kaya','CB','22','23','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','30','�ek Cumhuriyeti','Tomas Ujfalusi','CB','35','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','11','Ispanya','Albert Riera','CM','31','21','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','7','T�rkiye','Aydin Yilmaz','CM','25','3','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','52','T�rkiye','Emre �olak','CM','21','13','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','50','T�rkiye','Engin Baytar','CM','29','2','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','10','Brezilya','Felipe Melo','CM','29','23','1','6','2');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','23','T�rkiye','Furkan �z�al','CM','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','4','T�rkiye','Hamit Altintop','CM','30','28','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','53','Fas','Nordin Amrabat','CM','26','13','1','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','8','T�rkiye','Sel�uk Inan','CM','28','30','6','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','14','Hollanda','Wesley Sneijder','CM','28','10','3','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','35','T�rkiye','Yekta Kurtulus','CM','27','11','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','17','T�rkiye','Burak Yilmaz','ST','27','26','23','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','12','Fildisi Sahili','Didier Drogba','ST','35','10','5','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','9','Isve�','Johan Elmander','ST','31','11','4','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('8','19','T�rkiye','Umut Bulut','ST','30','17','12','2','1');");

				// Gaziantep
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','94','T�rkiye','Ahmet Ey�p T�rkaslan','GK','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','34','T�rkiye','Eray Birni�an','GK','24','1','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','91','T�rkiye','Mahmut Bezgin','GK','27','7','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','41','T�rkiye','�zden �ng�n','GK','34','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','1','Litvanya','Zydrunas Karcemarskas','GK','29','25','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','47','Avusturya','Ekrem Dag','CB','32','18','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','50','Karadag','Ivan Kecojevic','CB','25','27','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','13','T�rkiye','Kemal Tokak','CB','24','12','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','3','T�rkiye','Senol Can','CB','30','28','-','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','16','T�rkiye','Serdar Kurtulus','CB','25','31','1','9','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','35','T�rkiye','S�leyman �zdamar','CB','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','12','Burkina Faso','Abdou Traore','CM','24','2','2','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','8','T�rkiye','Bekir Ozan Has','CM','28','23','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','28','Kamerun','Gilles Binya','CM','28','29','-','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','4','Bosna Hersek','Haris Medunjanin','CM','28','28','4','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','20','T�rkiye','Ibrahim Halil Yasar','CM','19','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','77','T�rkiye','Oktay Delibalta','CM','27','4','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','61','T�rkiye','Orhan G�lle','CM','21','8','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','25','T�rkiye','Ridvan Simsek','CM','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','81','T�rkiye','Taskin �alis','CM','19','10','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','90','Brezilya','Wilton Figueiredo','CM','31','1','1','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','55','Avusturya','Yasin Pehlivan','CM','24','10','-','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','23','T�rkiye','Cenk Tosun','ST','21','28','9','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','9','Litvanya','Darvydas Sernas','ST','29','16','6','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','99','Kamerun','Dorge Kouemaha','ST','29','6','5','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','11','T�rkiye','Muhammet Demir','ST','21','5','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','15','T�rkiye','Serdar �zbayraktar','ST','31','10','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('9','7','T�rkiye','Turgut Dogan Sahin','ST','25','13','2','5','-');");

				// Gen�ler
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','35','T�rkiye','Ferhat Kaplan','GK','24','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','58','T�rkiye','�zkan Karabulut','GK','22','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','1','T�rkiye','Ramazan K�se','GK','25','29','-','3','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','94','T�rkiye','Ahmet Yilmaz �alik','CB','19','4','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','6','Hirvatistan','Ante Kulusic','CB','26','24','4','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','4','T�rkiye','Aykut Demir','CB','24','30','5','12','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','20','Arnavutluk','Debatik Curri','CB','29','6','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','3','Sirbistan','Dusko Tosic','CB','28','32','1','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','29','T�rkiye','Ilkay Durmus','CB','19','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','16','T�rkiye','Serkan Kurtulus','CB','23','12','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','40','T�rkiye','Cem Can','CM','32','29','-','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','5','T�rkiye','Doga Kaya','CM','28','1','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','23','T�rkiye','Ferhat �apa','CM','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','17','T�rkiye','Hursut Meri�','CM','29','25','3','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','21','Isve�','Jimmy Durmaz','CM','24','21','5','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','19','T�rkiye','Kerim Zengin','CM','28','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','77','Sirbistan','Nemanja Tomic','CM','25','5','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','67','T�rkiye','Okan K�se','CM','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','24','T�rkiye','�zg�r Ileri','CM','25','20','1','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','11','Sirbistan','Radosav Petrovic','CM','24','24','3','8','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','8','Kosta Rika','Randall Azofeifa','CM','28','26','3','7','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','99','T�rkiye','Artun Ak�akin','ST','20','5','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','95','T�rkiye','Atabey �i�ek','ST','17','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','18','Bel�ika','Bj�rn Vleminckx','ST','27','15','9','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','9','Sirbistan','Dejan Lekic','ST','27','10','3','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','12','Nijerya','Ekigho Ehiosun','ST','24','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('10','10','Bosna Hersek','Ermin Zec','ST','25','25','5','3','1');");

				// �stanbul BB
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','1','Portekiz','Eduardo Carvalho','GK','30','32','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','27','T�rkiye','Hakan Canbazoglu','GK','25','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','61','T�rkiye','Oguzhan Bahadir','GK','33','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','18','Portekiz','Andre Geraldes','CB','22','29','-','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','2','T�rkiye','Can Arat','CB','29','17','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','17','T�rkiye','Ekrem Eksioglu','CB','35','32','2','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','86','Gine','Kamil Zayatte','CB','28','21','1','6','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','5','T�rkiye','Mahmut Tekdemir','CB','25','22','1','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','3','T�rkiye','Metin Depe','CB','32','27','-','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','53','T�rkiye','Rizvan Sahin','CB','31','5','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','67','T�rkiye','Cenk Sahin','CM','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','20','T�rkiye','Cihan Haspolatli','CM','33','20','1','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','22','Brezilya','Doka Madureira','CM','29','19','5','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','13','Bosna Hersek','Edin Visca','CM','23','14','3','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','6','T�rkiye','Efe Inan�','CM','33','11','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','14','T�rkiye','�mer Can Sokullu','CM','24','10','3','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','23','Isve�','Samuel Holmen','CM','28','32','11','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','10','Almanya','Taner Yal�in','CM','23','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','8','T�rkiye','Zeki Korkmaz','CM','24','15','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','32','Nijerya','Simon Zenke','ST','24','10','2','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','7','T�rkiye','Tevfik K�se','ST','24','6','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('11','19','T�rkiye','Turgay Bahadir','ST','29','2','1','2','-');");

				// Karab�k
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','15','Isve�','Andreas Isaksson','GK','31','33','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','25','T�rkiye','Erta� �zbir','GK','23','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','1','T�rkiye','Ilker Avcibay','GK','34','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','61','T�rkiye','Abdurrahman Dereli','CB','32','28','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','22','T�rkiye','Baris Basdas','CB','23','12','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','49','T�rkiye','Elyasa S�me','CB','29','24','-','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','4','T�rkiye','Ilhan Eker','CB','30','8','1','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','21','Uruguay','Pablo Pintos','CB','25','-','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','5','T�rkiye','Sancak Kaplan','CB','30','29','-','7','2');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','3','T�rkiye','Volkan Yaman','CB','30','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','2','T�rkiye','Yal�in Ayhan','CB','31','30','1','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','24','Almanya','Fabian Ernst','CM','33','29','-','9','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','8','Bulgaristan','Georgi Sarmov','CM','27','14','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','7','T�rkiye','Halil �olak','CM','23','3','2','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','31','T�rkiye','H�seyin Kala','CM','26','5','2','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','14','Fildisi Sahili','Kafoumba Coulibaly','CM','27','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','20','T�rkiye','Kerem Seras','CM','29','17','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','18','T�rkiye','�zer Hurmaci','CM','26','26','6','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','28','Bosna Hersek','Senijad Ibricic','CM','27','12','4','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','10','T�rkiye','Adem B�y�k','ST','25','9','2','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','30','Angola','Djalma Braume','ST','25','18','2','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','9','Nijerya','Kalu Uche','ST','30','33','19','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','17','T�rkiye','Sahin Ayg�nes','ST','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','23','Uruguay','Santiago Garcia Correa','ST','22','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('13','19','Uruguay','Tabare Viudez','ST','23','17','5','2','-');");

				// Kayseri
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','34','T�rkiye','Deniz Mehmet','GK','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','1','T�rkiye','Ertugrul Taskiran','GK','23','30','-','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','12','T�rkiye','G�khan Degirmenci','GK','24','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','27','T�rkiye','Erdal Akdari','CB','19','4','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','5','T�rkiye','Eren G�ng�r','CB','25','19','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','2','Izlanda','Gretar Steinsson','CB','31','9','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','26','T�rkiye','Kamil Ahmet ��rek�i','CB','21','4','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','33','Sirbistan','Marko Simic','CB','25','14','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','42','T�rkiye','Mehmet Tahir Kalem','CB','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','25','T�rkiye','Nurettin Kayaoglu','CB','21','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','41','T�rkiye','Resul �zgen','CB','19','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','24','T�rkiye','Salih Dursun','CB','21','21','3','14','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','6','G�rcistan','Zurab Khizanishvili','CB','31','28','-','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','8','T�rkiye','Abdullah Durak','CM','26','20','-','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','19','Brezilya','Alex Silva Cleiton','CM','30','28','5','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','16','Paraguay','Cristian Riveros','CM','30','29','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','28','T�rkiye','Engin Bekdemir','CM','21','6','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','30','T�rkiye','Okay Yokuslu','CM','19','6','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','7','T�rkiye','Sefa Yilmaz','CM','23','24','7','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','13','Kamerun','Babacar Mbaye ','ST','19','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','9','Brezilya','Bobo','ST','27','30','17','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','21','Hollanda','Diego Biseswar','ST','25','6','3','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','15','T�rkiye','Murat Bildirici','ST','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','38','T�rkiye','�mer Bayram','ST','21','10','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('14','17','Arjantin','Pablo Mouche','ST','25','26','7','5','-');");

				// Mersin
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','38','Liechtenstein','Cengiz Bi�er','GK','25','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','35','�ek Cumhuriyeti','David Bicik','GK','31','11','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','12','Bosna Hersek','Ibrahim Sehic','GK','24','14','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','54','T�rkiye','Orkun Usak','GK','32','5','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','25','T�rkiye','Aydin Tos�ali','CB','32','8','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','6','Brezilya','Ivan De Souza','CB','31','27','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','3','Kamerun','Joseph Boum','CB','24','15','-','9','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','93','T�rkiye','Mert Can','CB','19','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','30','Sirbistan','Milan Mitrovic','CB','24','13','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','5','Sirbistan','Milan Stepanov','CB','30','23','3','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','23','T�rkiye','Mustafa Ke�eli','CB','34','19','1','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','41','T�rkiye','�mer Aysan Baris','CB','30','4','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','87','T�rkiye','Serkan Yanik','CB','26','24','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','24','Avusturya','Tanju Kayhan','CB','23','7','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','88','Nijerya','Adewole Raheem Lawal','CM','23','5','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','13','Tunus','Ben Yahia','CM','28','22','2','8','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','21','T�rkiye','Burhan Eser','CM','28','16','2','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','10','Arjantin','Emanuel Culio','CM','28','29','5','10','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','28','T�rkiye','Eren Tozlu','CM','22','3','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','55','T�rkiye','Hakan Bayraktar','CM','37','23','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','12','Gine','Ibrahima Yattara','CM','32','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','4','T�rkiye','Murat Ceylan','CM','25','14','1','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','33','T�rkiye','Murat Erdogan','CM','36','5','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','7','Nijerya','Nduka Morrison Ozokwo','CM','24','20','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','77','T�rkiye','Ozan Ipek','CM','26','3','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','19','T�rkiye','Can Erdem','ST','25','-','1','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','58','T�rkiye','Mehmet Yildiz','ST','31','4','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('15','11','T�rkiye','Mert Nobre','ST','32','29','13','7','-');");

				// Ordu
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','17','T�rkiye','Fevzi Elmas','GK','29','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','32','Slovenya','Saso Fornezzi','GK','30','30','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','14','Ispanya','Agus','CB','28','23','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','89','Fransa','Atilla Turan','CB','21','17','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','85','T�rkiye','Ferhat ��km�s','CB','28','16','-','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','78','T�rkiye','Ibrahim Kas','CB','26','13','-','8','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','15','Portekiz','Miguel Moita Garcia','CB','30','26','-','9','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','5','T�rkiye','�mer Alp Kulga','CB','24','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','84','Brezilya','Roversio','CB','29','7','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','27','T�rkiye','Sel�uk Sahin','CB','30','1','-','-','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','20','T�rkiye','Abd�lkadir Kayali','CM','22','-','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','8','T�rkiye','Ali �amdali','CM','29','31','3','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','75','Ispanya','Jaime Romero','CM','22','7','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','22','Arjantin','Javier Umbides','CM','31','28','2','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','7','T�rkiye','M�sl�m Yelken','CM','24','5','1','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','11','T�rkiye','Nizamettin �aliskan','CM','26','29','1','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','6','Almanya','Samil Cinaz','CM','27','22','4','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','26','Arjantin','Vicente Monje','CM','31','12','-','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','39','T�rkiye','Yigit G�koglan','CM','23','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','9','Romanya','Bogdan Stancu','ST','25','27','10','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','23','Ispanya','David Barral','ST','30','15','4','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','10','T�rkiye','Hasan Kabze','ST','30','23','5','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('16','','Almanya','Yasin Kocatepe','ST','21','-','-','-','-');");

				// Sivas
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','1','T�rkiye','Korcan �elikay','GK','25','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','18','Sirbistan','Milan Borjan','GK','25','29','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','89','T�rkiye','Nihat Sahin','GK','23','2','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','44','T�rkiye','Erhan G�ven','CB','31','19','-','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','58','T�rkiye','Hayrettin Yerlikaya','CB','31','2','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','21','�ek Cumhuriyeti','Jakub Navratil','CB','29','30','1','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','33','�ek Cumhuriyeti','Jan Rajnoch','CB','31','18','2','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','94','T�rkiye','Kaan Kilci','CB','18','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','4','T�rkiye','Murat Ak�a','CB','22','2','-','1','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','67','T�rkiye','Ugur Kavuk','CB','33','21','-','7','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','80','T�rkiye','�mit Kurt','CB','22','10','-','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','5','T�rkiye','Ziya Erdal','CB','25','30','1','8','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','92','Fransa','Aatif Chahechouhe','CM','26','25','6','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','11','T�rkiye','Erman Kili�','CM','29','32','5','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','8','T�rkiye','Kadir Bekmezci','CM','27','29','1','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','10','Polonya','Kamil Grosicki','CM','24','23','2','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','6','T�rkiye','Mehmet Nas','CM','33','5','2','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','16','�ek Cumhuriyeti','Milan Cerny','CM','25','2','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','22','Polonya','Arkadiusz Piech','ST','27','2','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','14','Nijerya','Michael Eneramo','ST','27','30','11','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','7','Bolivya','Ricardo Pedriel','ST','26','14','3','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('17','99','T�rkiye','Sercan Yildirim','ST','23','-','-','1','-');");

				// Trabzon
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','1','T�rkiye','Onur Recep Kivrak','ST','25','29','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','29','T�rkiye','Tolga Zengin','GK','29','4','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','89','T�rkiye','Zeki Ayvaz','GK','23','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','3','T�rkiye','Abdullah Karmil','CB','25','3','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','16','Hollanda','Alim �zt�rk','CB','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','86','Brezilya','Emerson Conceicao','CB','27','17','2','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','23','T�rkiye','Giray Ka�ar','CB','28','16','-','8','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','5','Slovakya','Marek Cech','CB','30','13','-','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','22','T�rkiye','Mustafa Yumlu','CB','25','25','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','28','�ek Cumhuriyeti','Ondrej Celustka','CB','23','17','-','4','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','30','T�rkiye','Serkan Balci','CB','29','24','-','5','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','6','Fildisi Sahili','Souleyman Bamba','CB','28','17','-','7','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','2','T�rkiye','Ugur D�ndar','CB','20','-','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','91','T�rkiye','Zeki Yavru','CB','21','5','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','10','Polonya','Adrian Mierzejewski','CM','26','18','5','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','25','Brezilya','Alanzinho','CM','30','12','1','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','18','T�rkiye','Aykut Akg�n','CM','25','4','-','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','15','Fildisi Sahili','Didier Zokora','CM','32','25','-','6','1');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','20','Arjantin','Gustavo Colman','CM','28','10','1','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','27','Slovakya','Marek Sapara','CM','30','14','2','2','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','92','T�rkiye','Olcan Adin','CM','27','26','7','5','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','14','T�rkiye','Soner Aydogdu','CM','22','15','1','4','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','40','T�rkiye','Volkan Sen','CM','25','6','3','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','11','T�rkiye','Yasin �ztekin','CM','26','17','3','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','9','T�rkiye','Emre G�ral','ST','24','1','-','-','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','21','T�rkiye','Halil Altintop','ST','30','20','7','1','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','83','Avusturya','Marc Janko','ST','29','7','1','3','-');");
				db.execSQL("INSERT INTO players(tid,kitnum,country,playername,position,age,lineupcount,goal,yellowcard,redcard) values('18','12','Brezilya','Paulo Henrique','ST','24','14','4','3','-');");

				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			onCreate(db);
		}
	}

	/**
	 * Opens the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public DatabaseAdapter open() throws SQLException {
		db = databaseHelper.getWritableDatabase();
		return this;
	}

	/**
	 * Closes the database
	 */
	public void close() {
		databaseHelper.close();
	}


	/**
	 * Retrieves every contact in the database
	 * @return
	 */
	//add your new attributes
	public Cursor getAllPlayers() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_ROWID2, KEY_KITNUM, KEY_COUNTRY, KEY_NAME, KEY_POSITION, KEY_AGE, KEY_LINEUP, KEY_GOAL, KEY_YELLOW, KEY_RED}, null, null, null, null, null);
	}
	
	// Getting all teams
	public Cursor getAllTeams() {
		return db.query(DATABASE_TABLE2, new String[] {}, null, null, null, null, null);
	}
	
	// Get team logo
	public Cursor getLogo(long p_tid) {
		return db.query(DATABASE_TABLE2, new String[] {}, KEY_ROWID2 + "=" + p_tid, null, null, null, null);
	}
	
	// Get players of particular team
	public Cursor getTeamPlayers(long team) {
		return db.query(DATABASE_TABLE, new String[] {KEY_KITNUM, KEY_NAME, KEY_POSITION}, KEY_ROWID2 + "=" + team, null, null, null, null);
	}

	// Find one player
	public Cursor getParticularPlayer(long tid, String name) {
		return db.query(DATABASE_TABLE, new String[] {KEY_GOAL, KEY_LINEUP, KEY_YELLOW, KEY_RED, KEY_AGE, KEY_COUNTRY, KEY_KITNUM, KEY_POSITION}, KEY_ROWID2 + "=" + tid + " AND " + KEY_NAME + "=?", new String [] {name}, null, null, null);
	}
	
	// Order by goals
	public Cursor getPlayersByGoal() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, KEY_GOAL + "!= '-'", null, null, null, KEY_GOAL + " DESC");
	}
	
	// Order by yellow
	public Cursor getPlayersByYellow() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, KEY_YELLOW + "!= '-'", null, null, null, KEY_YELLOW + " DESC");
	}
	
	// Order by red
	public Cursor getPlayersByRed() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, KEY_RED + "!= '-'", null, null, null, KEY_RED + " DESC");
	}
	
	// Order by age
	public Cursor getPlayersByAge() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, null, null, null, null, KEY_AGE + " DESC");
	}
	
	// Order by lineup count
	public Cursor getPlayersByLineup() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, KEY_LINEUP + "!= '-'", null, null, null, KEY_LINEUP + " DESC");
	}
	
	// Find one by name
	public Cursor getPlayerByName(String name) {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, KEY_NAME + " like ?", new String [] {"%"+name+"%"}, null, null, KEY_LINEUP + " DESC");
	}
	
	// Player's who are not a starter but booked
	public Cursor getFancy() {
		return db.query(DATABASE_TABLE, new String[] {KEY_ROWID2, KEY_NAME}, KEY_LINEUP + " = '-' AND "+ KEY_YELLOW + "!= '-'", null, null, null, KEY_YELLOW + " DESC");
	}
		
}