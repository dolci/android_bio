package com.tp.android;

import android.app.Activity;
import android.os.Bundle;

public class LoadingScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadingscreen);
	}
		public void onPause(){
			super.onPause();
			finish();
		}
}
