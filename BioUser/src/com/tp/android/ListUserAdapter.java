package com.tp.android;
import java.util.List;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListUserAdapter extends ArrayAdapter<User> {
	private int				resource;
	private LayoutInflater	inflater;
	private Context 		context;
	public ListUserAdapter ( Context ctx, int resourceId, List<User> objects) {
		super( ctx, resourceId, objects );
		resource = resourceId;
		inflater = LayoutInflater.from( ctx );
		context=ctx;
	}
	@Override
	public View getView ( int position, View convertView, ViewGroup parent ) { 
		convertView = ( RelativeLayout ) inflater.inflate( resource, null ); 
        User user = getItem( position );
				TextView legendName = (TextView) convertView.findViewById(R.id.legendName);
		legendName.setText(user.getName()+" "+user.getSurname());
		 
		TextView legendprof = (TextView) convertView.findViewById(R.id.legendProf);
		legendprof.setText(user.getProfession());
		 
		ImageView legendImage = (ImageView) convertView.findViewById(R.id.legendImage);
		String uri = "drawable/"+user.getUrlpic();
	    int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
	    Drawable image = context.getResources().getDrawable(imageResource);
	    legendImage.setImageDrawable(image);
	    
	  
		return convertView;
	}
}

