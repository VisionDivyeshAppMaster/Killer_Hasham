package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.heartconterx;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.likedbio;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.savedbio;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.savedcontex;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.sharepref;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.shareprefsave;
import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.yolo;


public class BioActivity extends AppCompatActivity {

    ImageView heart,copy,eye,share,edit,done,saved;
    TextView biotext;
    EditText bioedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        Log.e("sapata","Hashtag Activity");

        init();

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        if(utils.editflag == 1) {
            editmethod();
        }


        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bio = biotext.getText().toString();

                if(likedbio.size()==0){
                    likedbio.add(bio);
                    sharepref(heartconterx);
                    yolo(heartconterx);
                    Toast.makeText(getApplicationContext(), "Liked !", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ans = likedbio.contains(bio);

                    if (ans)
                        Toast.makeText(getApplicationContext(), "Liked !", Toast.LENGTH_SHORT).show();
                    else{
                        likedbio.add(bio);
                        sharepref(heartconterx);
                        yolo(heartconterx);
                        Toast.makeText(getApplicationContext(), "Liked !", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donemethod();
                String bio = biotext.getText().toString();


                if(savedbio.size()==0){
                    savedbio.add(bio);
                    shareprefsave(savedcontex);
                    //yolosave(getApplicationContext());
                    Toast.makeText(getApplicationContext(), "Saved !", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ans = savedbio.contains(bio);

                    if (ans)
                        Toast.makeText(getApplicationContext(), "ALready Saved !", Toast.LENGTH_SHORT).show();
                    else{
                        savedbio.add(bio);
                        shareprefsave(savedcontex);
                        //yolosave(getApplicationContext());

//                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Saved !", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", biotext.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(BioActivity.this, "Hashtag Copied", Toast.LENGTH_SHORT).show();

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editmethod();


            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                donemethod();

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shareBody = biotext.getText().toString();
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share Hashtag Using"));

            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bio = biotext.getText().toString();

                startActivity(new Intent(getApplicationContext(), EyeActivity.class));
                utils.biotext = bio;

            }
        });


    }

    private void donemethod() {
        biotext.setVisibility(View.VISIBLE);
        bioedit.setVisibility(View.GONE);
        edit.setVisibility(View.VISIBLE);
        done.setVisibility(View.GONE);

        String bio = bioedit.getText().toString();
        biotext.setText(bio);

        utils.editflag= 0;
    }

    private void editmethod() {

        heart.setVisibility(View.GONE);
        saved.setVisibility(View.VISIBLE);

        biotext.setVisibility(View.GONE);
        bioedit.setVisibility(View.VISIBLE);
        edit.setVisibility(View.GONE);
        done.setVisibility(View.VISIBLE);

        String bio = biotext.getText().toString();
        bioedit.setText(bio);
    }



    private void init () {
        biotext = findViewById(R.id.biotext);
        heart = findViewById(R.id.heart);
        copy = findViewById(R.id.copy);
        eye = findViewById(R.id.eye);
        share = findViewById(R.id.share);
        edit = findViewById(R.id.edit);
        done = findViewById(R.id.done);
        saved = findViewById(R.id.saved);

        bioedit = findViewById(R.id.editbio);
        biotext.setText(utils.biotext);

        heart.setVisibility(View.VISIBLE);
        saved.setVisibility(View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}