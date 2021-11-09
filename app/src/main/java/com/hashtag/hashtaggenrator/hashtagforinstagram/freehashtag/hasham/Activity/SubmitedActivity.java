package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.SubmittedAdapter;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class SubmitedActivity extends AppCompatActivity {

    GridView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submited);

        recyclerView =findViewById(R.id.savedgrid);

        Log.e("sapata","Submitted Activity");

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        utils.submitedcontex = getApplicationContext();

        recyclerView.setAdapter(new SubmittedAdapter(utils.submiteddbio));
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));
                utils.biotext = utils.submiteddbio.get(position);
                Log.e("TTTT","Mi---tag>"+position);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
