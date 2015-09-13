package com.tp.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class Main extends Activity {

   private Camera cameraObject;
   private ShowCamera showCamera;
  public static Bitmap bitmap;
  
   public static Camera isCameraAvailiable(){
      Camera object = null;
      try {
         object = Camera.open(); 
      }
      catch (Exception e){
      }
      return object; 
   }
   public Bitmap getBitmap()
   {return bitmap;}
   private PictureCallback capturedIt = new PictureCallback() {

      @Override
      public void onPictureTaken(byte[] data, Camera camera) {

       bitmap = BitmapFactory.decodeByteArray(data , 0, data .length);
      if(bitmap==null){
         Toast.makeText(getApplicationContext(), "not taken", Toast.LENGTH_SHORT).show();
      }
      else
      {
         Toast.makeText(getApplicationContext(), "taken", Toast.LENGTH_SHORT).show();
         FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
         //pic.setImageBitmap(bitmap);
        // preview.setBackground(pic);
         
      }
      cameraObject.release();
   }
};

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      cameraObject = isCameraAvailiable();
      showCamera = new ShowCamera(this, cameraObject);
      FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
   //   preview.addView(showCamera);
   }
   public void snapIt(View view){
      cameraObject.takePicture(null, null, capturedIt);
   }

   
}