package com.tp.android;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBAdapter {

	DatabaseHelper	DBHelper;
	Context			context;
	SQLiteDatabase	db;
	
	public DBAdapter(Context context){
		this.context = context;
		DBHelper = new DatabaseHelper(context);
	}	
	
	public class DatabaseHelper extends SQLiteOpenHelper{

		Context			context;
		
		public DatabaseHelper(Context context) {
			super(context, "users_b", null, 1);
			this.context = context;
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("create table users_b (_id integer primary key autoincrement, "
					+ "name text not null,surname text not null,profession text not null,dateb text not null"
					+ ");");			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Toast.makeText(context, "Mise à jour de la Base de données version "+oldVersion+" vers "+newVersion, Toast.LENGTH_SHORT).show();
			db.execSQL("DROP TABLE IF EXISTS users_b");
			onCreate(db);
		}
		
	}
	
	public DBAdapter open(){
		db = DBHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		db.close();
	}
	
	public void Truncate(){
		db.execSQL("DELETE FROM users_b");
	}
	
	public long insererUser(String name, String surname, String profession,String dateb){
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("surname", surname);
		values.put("profession", profession);
		values.put("dateb", dateb);
		return db.insert("users_b", null, values);
	}
	
	
	public boolean supprimerUser(long id){
		return db.delete("users_b", "_id="+id, null)>0;
	}
	
	public Cursor recupererLaListeUsers(){
		return db.query("users_b", new String[]{
				"_id",
				"name",
				"surname",
				"profession",
				"dateb"
				}, null, null, null, null, null);
	}
	
}
