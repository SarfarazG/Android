package com.example.myapp;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	final static int cameradata = 0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.zehra);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void initialize() {

		ib = (ImageButton) findViewById(R.id.ibtakepic);
		b = (Button) findViewById(R.id.bSetWall);
		iv = (ImageView) findViewById(R.id.ivReturnPic);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.ibtakepic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameradata);
			break;
		case R.id.bSetWall:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {

			Bundle extra = data.getExtras();
			bmp = (Bitmap) extra.get("data");
			iv.setImageBitmap(bmp);
		}
	}

}
