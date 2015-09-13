package com.tp.android;

import java.util.Calendar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.fourmob.datetimepicker.date.DatePickerDialog.OnDateSetListener;

public class EditInterface extends FragmentActivity implements OnDateSetListener{

    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";
    public EditText name,surname,profession;
    Intent inter ;
    public TextView date;
    BioBase bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editnterface);

       inter = new Intent();
       bb=new BioBase(this);
        final Calendar calendar = Calendar.getInstance();
       
        name=(EditText)findViewById(R.id.name);
        surname=(EditText)findViewById(R.id.surname);
        profession=(EditText)findViewById(R.id.prof);
        date=(TextView)findViewById(R.id.datepicker);
		if(inter.hasExtra("message"))
		{
		String message1 = inter.getStringExtra(Interface1.message);
		String []lis=message1.split(" ");
		
        name.setText(lis[0]); 
        surname.setText(lis[1]);
        profession.setText(lis[2]);
        date.setText(lis[3]);
        }
		Button edit=(Button)findViewById(R.id.Edit);
        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), true);
       

        findViewById(R.id.picker).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });


        findViewById(R.id.saveDate).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v1) {
         
            User user=new User();
            //	user.setDatebirth(date.getText().toString());
             //  db.insererUser(name.getText().toString(),surname.getText().toString(),profession.getText().toString(),date.getText().toString());
            	Toast.makeText(EditInterface.this,inter.getStringExtra("message"), Toast.LENGTH_LONG).show();
              if(inter.hasExtra("message"))
               {
            	   
            	       inter.putExtra("editpro", name.getText().toString()+" "+surname.getText().toString()+" "
                      	  + profession.getText().toString()+" "+date.getText().toString());
                         setResult(RESULT_OK,inter);        
                       finish();
               }
               else
               {
            	   
            	   user.setDatebirth(date.getText().toString());user.setName(name.getText().toString());user.setSurname(surname.getText().toString());
            	   user.setProfession(profession.getText().toString());user.setUrlpic("rihanna");
            	   bb.addUser(user);
            	   Toast.makeText(EditInterface.this, " saveuser", Toast.LENGTH_LONG).show();
              // inter.putExtra("editpro", name.getText().toString()+" "+surname.getText().toString()+" "
            	//	  + profession.getText().toString()+" "+date.getText().toString());
              // setResult(RESULT_OK,inter);        
            //   finish();
               //db.close();
               }
            }
        });
        if (savedInstanceState != null) {
            DatePickerDialog dpd = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag(DATEPICKER_TAG);
            if (dpd != null) {
                dpd.setOnDateSetListener(this);
            }

           
        }
    }

    
    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
       // Toast.makeText(MainActivity.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
        TextView t=(TextView)findViewById(R.id.datepicker);
        t.setText( year + "-" + month + "-" + day);  
    }

    
}
