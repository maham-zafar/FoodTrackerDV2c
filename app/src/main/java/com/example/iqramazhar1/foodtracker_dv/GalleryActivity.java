package com.example.iqramazhar1.foodtracker_dv;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {


    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");

        getIncomingIntent();
    }

    private void getIncomingIntent()
    {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image_url")&&getIntent().hasExtra("image_name")){
            Log.d(TAG, " getIncomingIntent: found intent extras ");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName=getIntent().getStringExtra("image_name");

            setImage(imageUrl,imageName);
        }


    }

    private void setImage( String imageUrl, String imageName ) {
        Log.d(TAG, "setImage: setting to image and name to widget");

        TextView name = findViewById(R.id.image_descryption);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);


    }
}

