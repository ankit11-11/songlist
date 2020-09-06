package com.example.songlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Song> songs;
    private static String JSON_URL = "http://starlord.hackerearth.com/studio";
    Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.songlist);
        songs = new ArrayList<>();
        extractsongs();



    }

    private void extractsongs() {
        RequestQueue Queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i =0;1 < response.length();i++){
                    try{
                        JSONObject songsObject = response.getJSONObject(i);

                        Song song = new Song();
                        song.setTittle(songsObject.getString("song"));
                        song.setArtiats(songsObject.getString("artists"));
                        song.setCoverImage(songsObject.getString("cover_image"));
                        song.setSongURL(songsObject.getString("url"));
                        songs.add(song);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapter = new Adapter(MainActivity.this,songs);
                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("ankit",error.getMessage());
            }
        });
        Queue.add(jsonArrayRequest);

    }


}