package com.example.aggiefeedtest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    ListView lv_aggiefeed_activies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_aggiefeed_activies = findViewById(R.id.lv_aggiefeed_activities);

        AggieFeedService aggieFeedService = new AggieFeedService(MainActivity.this);

        aggieFeedService.fetchData(new AggieFeedService.VolleyResponseListener() {

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, "Data is Currently Not Available.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<AggieDataModel> data) {

                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, data);
                lv_aggiefeed_activies.setAdapter(arrayAdapter);
                lv_aggiefeed_activies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, "View ID: " + view.getId() + "Position: " + position + "ID: " + id, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this, "View: " + data.get(position).toString() , Toast.LENGTH_SHORT).show();
                        Intent detailedAggieView = new Intent(MainActivity.this, DisplayAggiePostActivity.class).putExtra("post", data.get(position));
                        startActivity(detailedAggieView);

                    }
                });

//                Toast.makeText(MainActivity.this, "" + data.size() , Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "Inserted Data!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

