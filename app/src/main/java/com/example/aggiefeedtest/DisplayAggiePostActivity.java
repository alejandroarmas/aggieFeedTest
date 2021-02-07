package com.example.aggiefeedtest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAggiePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        AggieDataModel aggiePostData = getIntent().getExtras().getParcelable("post");

        TextView titleView = findViewById(R.id.title);
        TextView displayNameView = findViewById(R.id.displayName);
        TextView objectTypeView = findViewById(R.id.objectType);
        TextView publishedView = findViewById(R.id.published);

        titleView.setText(aggiePostData.getTitle());
        displayNameView.setText(aggiePostData.getDisplayName());
        objectTypeView.setText(aggiePostData.getObjectType());
        publishedView.setText(aggiePostData.getPublished());

    }

}