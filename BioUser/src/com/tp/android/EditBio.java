package com.tp.android;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditBio extends Activity  {
    EditText desc;
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editbio);
		
		
		 desc=(EditText)findViewById(R.id.desce);
      /*  name.setText(lis[0]); 
        surname.setText(lis[1]);
        prof.setText(lis[2]);
        date.setText(lis[3]);*/
		Button save1=(Button)findViewById(R.id.save1);
		
		save1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
	     Intent inter = new Intent();  
	     inter.putExtra("editbio",desc.getText().toString());
	     setResult(RESULT_OK,inter);        
         finish();
         //EditText editText = (EditText) findViewById(R.id.edit_message);
	//	String message = editText.getText().toString();
		//intent.putExtra(EXTRA_MESSAGE, message);
		}
		});

}
	
	
	}
