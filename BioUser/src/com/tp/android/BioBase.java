package com.tp.android;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

 public class BioBase extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "DataBaseUser";
	public BioBase(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
	// SQL statement to create book table
	String CREATE_USER_TABLE = "CREATE TABLE users ( " +
			"id INTEGER PRIMARY KEY AUTOINCREMENT, " +"name TEXT, "+
			"surname TEXT,"+"profession TEXT, "+"dateb TEXT, "+
			"description TEXT, "+"urlpic TEXT )";
			// create user table
			db.execSQL(CREATE_USER_TABLE);
			}
			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// Drop older books table if existed
			db.execSQL("DROP TABLE IF EXISTS users");
			// create fresh books table
			this.onCreate(db);
			}
			

			private static final String TABLE_USERS = "users";
			// users Table Columns names
			private static final String KEY_ID = "id";
			private static final String KEY_NAME = "name";
			private static final String KEY_SURNAME = "surname";
			private static final String KEY_PROFESSION = "profession";
			private static final String KEY_DATEBIRTH = "dateb";
			private static final String KEY_DESCRIPTION = "description";
			private static final String KEY_URLPIC = "urlpic";
			private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_SURNAME,KEY_PROFESSION,KEY_DATEBIRTH, KEY_DESCRIPTION,KEY_URLPIC};
	public void addUser(User user){
			Log.d("ADDUSER", user.toString());
			// 1. get reference to writable DB
			SQLiteDatabase db = this.getWritableDatabase();
			// 2. create ContentValues to add key "column"/value
			ContentValues values = new ContentValues();
			values.put(KEY_NAME, user.getName()); 
			values.put(KEY_SURNAME, user.getSurname()); 
			values.put(KEY_PROFESSION, user.getProfession()); // ge
			values.put(KEY_DATEBIRTH, user.getDatebirth());
			values.put(KEY_DESCRIPTION, user.getDescription());
			values.put(KEY_URLPIC, user.getUrlpic());
			db.insert(TABLE_USERS, // table
					null, //nullColumnHack
					values); // key/value -> keys = column names/ values = column values
					// 4. close
					db.close();
					}
		public User getUser(int id){
						SQLiteDatabase db = this.getReadableDatabase();
						// 2. build query
						Cursor cursor =
						db.query(TABLE_USERS, // a. table
						COLUMNS, // b. column names
						" id = ?", // c. selections
						new String[] { String.valueOf(id) }, // d. selections args
						null, // e. group by
						null, // f. having
						null, // g. order by
						null); // h. limit
						// 3. if we got results get the first one
						if (cursor != null)
						cursor.moveToFirst();
						// 4. build book object
						User user = new User();
						user.setId(Integer.parseInt(cursor.getString(0)));
						user.setName(cursor.getString(1));
						user.setSurname(cursor.getString(2));
						user.setProfession(cursor.getString(3));
						user.setDatebirth(cursor.getString(4));
						user.setDescription(cursor.getString(5));
						user.setUrlpic(cursor.getString(6));
						Log.d("getuser("+id+")", user.toString());
						return user;
					}
					// Get All uers
		public List<User> getAllUsers() {
					List<User> users = new LinkedList<User>();
					// 1. build the query
					String query = "SELECT * FROM " + TABLE_USERS;
					// 2. get reference to writable DB
					SQLiteDatabase db = this.getWritableDatabase();
					Cursor cursor = db.rawQuery(query, null);
					// 3. go over each row, build book and add it to list
					User user = null;
					if (cursor.moveToFirst()) {
						do {
							user = new User ();
							user.setId(Integer.parseInt(cursor.getString(0)));
							user.setName(cursor.getString(1));
							user.setSurname(cursor.getString(2));
							user.setProfession(cursor.getString(3));
							user.setDatebirth(cursor.getString(4));
							user.setDescription(cursor.getString(5));
							user.setUrlpic(cursor.getString(6));
							// Add book to books
							users.add(user);
							} while (cursor.moveToNext());
							}
					Log.d("getAllBooks()", users.toString());
					// return users
					return users;
					}
					// Updating single user
		public int updateUserk(User user) {
					// 1. get reference to writable DB
					SQLiteDatabase db = this.getWritableDatabase();
					// 2. create ContentValues to add key "column"/value
					ContentValues values = new ContentValues();
					values.put("name", user.getName()); 
					values.put("surname", user.getSurname()); 
					values.put("profession", user.getProfession()); 
					values.put("datebirth", user.getDatebirth());
					values.put("description", user.getDescription());
					values.put("urlpic", user.getUrlpic());
					
					// 3. updating row
					int i = db.update(TABLE_USERS, //table
					values, // column/value
					KEY_ID+" = ?", // selections
					new String[] { String.valueOf(user.getId()) }); //selection
					db.close();
					return i;
					}
					// Deleting single book
			public void deleteUser(User user) {
					// 1. get reference to writable DB
					SQLiteDatabase db = this.getWritableDatabase();
					// 2. delete
					db.delete(TABLE_USERS,
					KEY_ID+" = ?",
					new String[] { String.valueOf(user.getId()) });
					// 3. close
					db.close();
					Log.d("deleteBuser", user.toString());
					}
					

					}
					