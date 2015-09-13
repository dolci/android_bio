package com.tp.android;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
public class Interface1 extends Activity{
	 
	 public TextView name,surname,prof,date,desc;
	 ImageButton btimage;
	 public static String message;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interface1);
		
		name=(TextView)findViewById(R.id.namei);
		 surname=(TextView)findViewById(R.id.surnamei);
		 prof=(TextView)findViewById(R.id.profi);
		 date=(TextView)findViewById(R.id.dateBi);
		 desc=(TextView)findViewById(R.id.desc);
		 btimage=(ImageButton )findViewById(R.id.pic);
		 Intent intent1 = getIntent();
		 BioBase bb=new BioBase(this);
		 if(intent1.hasExtra("Id"))
		 {
			 message=intent1.getStringExtra("Id");
			 name.setText(bb.getUser(Integer.parseInt(message)).getName()); 
		       surname.setText(bb.getUser(Integer.parseInt(message)).getSurname());
		        prof.setText(bb.getUser(Integer.parseInt(message)).getProfession());
		        date.setText(bb.getUser(Integer.parseInt(message)).getDatebirth());
		        String uri = "drawable/"+bb.getUser(Integer.parseInt(message)).getUrlpic();
			    int imageResource = this.getResources().getIdentifier(uri, null, this.getPackageName());
			    Drawable image = this.getResources().getDrawable(imageResource);
			    btimage.setImageDrawable(image);
		 }
		
		 Button edit=(Button)findViewById(R.id.Edit);
		// bb.getUser(Integer.parseInt(message1));
       
		
		edit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
	     Intent inter = new Intent(Interface1.this,EditInterface.class);  
	     inter.putExtra(message, name.getText().toString()+" "+surname.getText().toString()+" "
       		  + prof.getText().toString()+" "+date.getText().toString());
	   //  startActivity(inter);
	    startActivityForResult(inter,0);
		//EditText editText = (EditText) findViewById(R.id.edit_message);
	//	String message = editText.getText().toString();
		//intent.putExtra(EXTRA_MESSAGE, message);
		}
		});
  Button edit1=(Button)findViewById(R.id.Edit1);
		
		edit1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
	     Intent inter = new Intent(Interface1.this,EditBio.class);  
	     inter.putExtra(message,desc.getText().toString());
	     startActivityForResult(inter,1);
		//EditText editText = (EditText) findViewById(R.id.edit_message);
	//	String message = editText.getText().toString();
		
		}
		});
	    btimage=(ImageButton)findViewById(R.id.pic);
		btimage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent inter = new Intent(Interface1.this,Main.class);
				 startActivity(inter);
				//btimage.setImageBitmap(Main.bitmap);
				//Toast.makeText(Interface1.this, " save user", Toast.LENGTH_LONG).show();
			}
			
		});
}
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
   	{
       	switch(requestCode) {
       	case 0: 
               if (resultCode == RESULT_OK) {
                   
                   {
                	   String message1 = data.getStringExtra("editpro");   
               		  String []lis=message1.split(" ");
                        name.setText(lis[0]); 
                       surname.setText(lis[1]);
                       prof.setText(lis[2]);
                       date.setText(lis[3]);   
                   }
                  
                   break;
               }
       	case 1: 
            if (resultCode == RESULT_OK) {
                
                {
             	   String message1 = data.getStringExtra("editbio");   
            	
                    desc.setText(message1);   
                }
               
                break;
            }
       	}
    
   	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_userlistview, menu);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
		case R.id.menu_about:
			// Comportement du bouton "A Propos"
			return true;
		case R.id.menu_help:
			// Comportement du bouton "Aide"
			return true;
		case R.id.menu_refresh:
			// Comportement du bouton "Rafraichir"
			return true;
		case R.id.menu_search:
			// Comportement du bouton "Recherche"
			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}