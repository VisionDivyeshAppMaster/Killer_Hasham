package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyZone;
import com.airbnb.lottie.LottieAnimationView;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class submit extends AppCompatActivity {

    ImageView edit;
    Button submit;
    TextView biotext;
    EditText bioedit;
    LinearLayout linearLayout;
    LottieAnimationView share,done;

    private final String APP_ID = "app801b6402e4b741ad8b";
    private final String ZONE_ID = "vzc8fd799f505d4d4c9c";
    private final String TAG = "AdColonyBannerDemo";

    private AdColonyAdViewListener listener;
    private AdColonyAdOptions adOptions;
    private RelativeLayout adContainer;
    private ProgressBar progressBar;
    private AdColonyAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        // banner ads adColony
        adContainer = findViewById(R.id.ad_container);
        progressBar = findViewById(R.id.progress);

        if (adContainer.getChildCount() > 0) {
            adContainer.removeView(adView);
        }

        progressBar.setVisibility(View.VISIBLE);


        AdColonyAppOptions appOptions = new AdColonyAppOptions();
        AdColony.configure(this, appOptions, APP_ID, ZONE_ID);

        listener = new AdColonyAdViewListener() {
            @Override
            public void onRequestFilled(AdColonyAdView adColonyAdView) {
                Log.d(TAG, "onRequestFilled");
                resetUI();
                adContainer.addView(adColonyAdView);
                adView = adColonyAdView;
            }

            @Override
            public void onRequestNotFilled(AdColonyZone zone) {
                super.onRequestNotFilled(zone);
                Log.d(TAG, "onRequestNotFilled");
                resetUI();
            }

            @Override
            public void onOpened(AdColonyAdView ad) {
                super.onOpened(ad);
                Log.d(TAG, "onOpened");
            }

            @Override
            public void onClosed(AdColonyAdView ad) {
                super.onClosed(ad);
                Log.d(TAG, "onClosed");
            }

            @Override
            public void onClicked(AdColonyAdView ad) {
                super.onClicked(ad);
                Log.d(TAG, "onClicked");
            }

            @Override
            public void onLeftApplication(AdColonyAdView ad) {
                super.onLeftApplication(ad);
                Log.d(TAG, "onLeftApplication");
            }
        };
        requestBannerAd();


        Log.e("sapata","Submit Activity");

        init();

        Toolbar mToolbar;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bioedit.getText().toString().length() == 0 || biotext.getText().toString().length() == 0) {

                    Toast.makeText(com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.submit.this, "Wtite Bio First", Toast.LENGTH_SHORT).show();
                    //hideKeyboard();

                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    View view =getCurrentFocus();
                    if (view == null) {
                        view = new View(getApplication());
                    }
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }

                }
                else {

                    Toast.makeText(com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.submit.this, "Hashtag Sumbited ! Check Saved Hashtag", Toast.LENGTH_SHORT).show();
                    donemethod();

                    utils.submiteddbio.add(biotext.getText().toString());
                    utils.shareprefsub(getApplicationContext());
                    biotext.setText("");

                    startActivity(new Intent(getApplicationContext(), SubmitedActivity.class));
                    finish();

                }
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

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });

    }

    private void resetUI() {

        progressBar.setVisibility(View.GONE);
    }

    private void requestBannerAd() {

        adOptions = new AdColonyAdOptions();
        AdColony.requestAdView(ZONE_ID, listener, AdColonyAdSize.BANNER, adOptions);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view =getCurrentFocus();
        if (view == null) {
            view = new View(getApplication());
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void donemethod() {
        biotext.setVisibility(View.VISIBLE);
        bioedit.setVisibility(View.GONE);
        edit.setVisibility(View.VISIBLE);
        done.setVisibility(View.GONE);

        String bio = bioedit.getText().toString();
        biotext.setText(bio);

        hideKeyboard();

        utils.editflag= 0;
    }

    private void editmethod() {
        biotext.setVisibility(View.GONE);
        bioedit.setVisibility(View.VISIBLE);
        edit.setVisibility(View.GONE);
        done.setVisibility(View.VISIBLE);

        String bio = biotext.getText().toString();
        bioedit.setText(bio);
    }

    private void init() {
        share = findViewById(R.id.share);
        edit = findViewById(R.id.edit);
        done = findViewById(R.id.done);

        submit = findViewById(R.id.submit);

        bioedit = findViewById(R.id.editbio);
        biotext = findViewById(R.id.biotext);

        linearLayout = findViewById(R.id.mainlayout);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}