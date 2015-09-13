package com.tp.android;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewActivity extends Activity {

	public ListView listViewUser;
	private Context ctx;
	
	public BioBase bb;
	
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlistview);        
        ctx=this;
        bb=new BioBase(ctx);
        
     // bb.addUser(new User("naruto","naruto","naruto"));
    //  bb.addUser(new User("tweety","twity","tweety"));
        
		List<User> legendList= bb.getAllUsers();
		
		bb.close();
		listViewUser = (ListView ) findViewById( R.id.User_list);
		listViewUser.setAdapter( new ListUserAdapter(ctx, R.layout.user_row_item, legendList ) );
    
		// Click event for single list row
		listViewUser.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
							 
				//Intent inter = new Intent(ListViewActivity.this,Interface1.class);
				// inter.putExtra("Id",""+user.getId());
				//     startActivityForResult(inter,0);
				//Toast.makeText(ListViewActivity.this, ""+user.getId()+user.getName().toString(), Toast.LENGTH_SHORT).show();
				     Thread t = new Thread(){
							public void run(){
							try{
							Intent intent = new Intent(getApplicationContext(),LoadingScreen.class);
							startActivity(intent);
							sleep(2000);
							}catch(Exception e){
								e.printStackTrace();
							}
							finally{
								final User user = (User) parent.getItemAtPosition(position); 
								Intent intent = new Intent(getApplicationContext(),Interface1.class);
								//intent.putExtra("Id",""+user.getId());
							//     startActivityForResult(intent,0);
								Bundle b = new Bundle();
								
								b.putString("Id",""+user.getId());
								intent.putExtras(b);
								startActivity(intent);
							}
							}
						};
						t.start();
			
			
			
			}
		});		
       }
    @Override
   	public boolean onCreateOptionsMenu(Menu menu) {
   		getMenuInflater().inflate(R.menu.activity_userlistview, menu);
   		
   		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   		return true;
   	}

   	@Override
   	public boolean onOptionsItemSelected(MenuItem item) {
   		switch (item.getItemId()) {
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
   		case R.id.menu_add:
   		{
   			 
			 
			 Thread t = new Thread(){
					public void run(){
					try{
					Intent intent = new Intent(getApplicationContext(),LoadingScreen.class);
					startActivity(intent);
					sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						
						Intent inter = new Intent(ListViewActivity.this,EditInterface.class);
			   			/* Bundle b = new Bundle();
						 b.putString("add","0000");
						 inter.putExtras(b);*/
						 startActivity(inter);
						
				
					}
					}
				};
				t.start();
	
	
   			
   		}
   			// Comportement du bouton "Param�tres"
   			return true;
   		default:
   			return super.onOptionsItemSelected(item);
   		}
   	}
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
   	{
       	switch(requestCode) {
       	case 0: 
               if (resultCode == RESULT_OK) {
                   
                   {
                  
                   }
                  
                   break;
               }
       
    
   	} 
}
   
}
