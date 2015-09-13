package com.tp.android;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageLoaderView extends ImageView {

	
	public ImageLoaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void loadImage(String url) {
		new DownloadImage(this).execute(url);
	}

	private class DownloadImage extends AsyncTask {

		final ImageView imageView;

		public DownloadImage(ImageView imageView) {
			this.imageView = imageView;
		}

		protected Bitmap doInBackground(String... params) {
			if (params.length == 0)
				return null;

			try {
				URL url = new URL(params[0]);
				InputStream stream = url.openStream();

				Bitmap bf = BitmapFactory.decodeStream(stream);

				return bf;

			} catch (MalformedURLException e) {
				return null;
			} catch (IOException e) {
				return null;
			}
		}

		protected void onPostExecute(Bitmap result) {
			if(result != null)
				imageView.setImageBitmap(result);

			super.onPostExecute(result);
		}

		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}