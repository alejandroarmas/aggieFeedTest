package com.example.aggiefeedtest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AggieFeedService {

    public static final String QUERY_FOR_AGGIE_DATA = "https://aggiefeed.ucdavis.edu/api/v1/activity/public?s=0?l=25";
    Context context;

    public AggieFeedService(Context context) {
        this.context = context;
    }

    // We use a callback to schedule method once fetchData method completes
    // We define the interface in AggieFeedService.java and define in MainActivity.java/ fetchData method
    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(List<AggieDataModel> aggieDataModels);

    }

    // Background Process
    public void fetchData(VolleyResponseListener volleyResponseListener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = QUERY_FOR_AGGIE_DATA;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

        List<AggieDataModel> aggieDataModels = new ArrayList<AggieDataModel>();

            @Override
            public void onResponse(JSONArray jsonArray) {

                try {

                    for (int n = 0; n < jsonArray.length(); n++) {

                        JSONObject aggieJson = jsonArray.getJSONObject(n);

                        String title = aggieJson.getString("title");
                        String displayName = aggieJson.getJSONObject("actor").getString("displayName");
                        String objectType = aggieJson.getJSONObject("object").getString("objectType");
                        String published = aggieJson.getString("published");
                        AggieDataModel aggieData = new AggieDataModel(title, displayName, objectType, published);
                        aggieDataModels.add(aggieData);

                    }


                    JSONObject activity = jsonArray.getJSONObject(0);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                volleyResponseListener.onResponse(aggieDataModels);
            }
        }, new Response.ErrorListener() {
            @Override
            public void  onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Error Occurred!");
            }
        });

        // Add the request to the RequestQueue.
        MySingleton.getInstance(this.context).addToRequestQueue(jsonArrayRequest);
    }

}
