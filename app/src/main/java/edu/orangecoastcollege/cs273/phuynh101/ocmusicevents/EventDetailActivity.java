package edu.orangecoastcollege.cs273.phuynh101.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Intent mIntent = getIntent();
        String title = mIntent.getStringExtra("title");
        String details = mIntent.getStringExtra("details");

        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        titleTextView.setText(title);
        detailsTextView.setText(details);

        //Use the assest manager to  retireve a file
        AssetManager am = getAssets();
        String imageFileName = title.replace(" ", "")+ ".jpeg";

        //Use the asset manager to open a stream to the file name
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream,title);
            eventImageView.setImageDrawable(image);
        }catch(IOException e)
        {
            Log.e("OC Music Events", "error loading image: " + imageFileName, e);
        }
    }

    protected void goBackToList(View v)
    {
        finish();
    }
}
