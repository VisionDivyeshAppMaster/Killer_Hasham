package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.SavedAdapter;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class saved extends AppCompatActivity {

    GridView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);


        Log.e("sapata","Saved Activity");

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        utils.savedcontex = getApplicationContext();
        recyclerView =findViewById(R.id.savedbiogrid);

        recyclerView.setAdapter(new SavedAdapter(utils.savedbio));
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));
                utils.biotext = utils.savedbio.get(position);
                Log.e("TTTT","Mi---saved>"+position);
            }
        });

    }
    @Override
public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
}
}
