package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.LikeAdapter;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class heart extends AppCompatActivity {

    GridView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);

        Log.e("sapata","Heart Activity");

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView =findViewById(R.id.likedgrid);
        utils.heartconterx = getApplicationContext();


        recyclerView.setAdapter(new LikeAdapter(utils.likedbio));
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));
                utils.biotext = utils.likedbio.get(position);
                Log.e("TTTT","Mi---tag>"+position);
            }
        });

    }

    @Override
public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
}
}
