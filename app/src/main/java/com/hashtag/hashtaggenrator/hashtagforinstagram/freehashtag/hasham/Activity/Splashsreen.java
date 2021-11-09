package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

public class Splashsreen extends AppCompatActivity {


    private final String APP_ID = "app801b6402e4b741ad8b";
    private final String ZONE_ID = "vza6ef94e4656240dca5";
    private final String TAG = "AdColonyDemo";
    private AdColonyInterstitial ad;
    private AdColonyInterstitialListener listener;
    private AdColonyAdOptions adOptions;
    private ProgressBar progress;


    private ProgressDialog pDialog;


    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashsreen);

         new GetContacts().execute();

//        AdColonyAppOptions appOptions = new AdColonyAppOptions()
//                .setUserID("unique_user_id")
//                .setKeepScreenOn(true);
//
//        AdColony.configure(this, appOptions, APP_ID, ZONE_ID);
//
//        listener = new AdColonyInterstitialListener() {
//            @Override
//            public void onRequestFilled(AdColonyInterstitial ad) {
//                // Ad passed back in request filled callback, ad can now be shown
//                Splashsreen.this.ad = ad;
//
////                ad.show();
////                progress.setVisibility(View.INVISIBLE);
//                Log.d(TAG, "onRequestFilled");
//            }
//
//            @Override
//            public void onRequestNotFilled(AdColonyZone zone) {
//                // Ad request was not filled
////                progress.setVisibility(View.INVISIBLE);
//                Log.d(TAG, "onRequestNotFilled");
//            }
//
//            @Override
//            public void onOpened(AdColonyInterstitial ad) {
//                // Ad opened, reset UI to reflect state change
//
////                progress.setVisibility(View.VISIBLE);
//                Log.d(TAG, "onOpened");
//            }
//
//            @Override
//            public void onExpiring(AdColonyInterstitial ad) {
//                // Request a new ad if ad is expiring
//
////                progress.setVisibility(View.VISIBLE);
//                AdColony.requestInterstitial(ZONE_ID, this, adOptions);
//                Log.d(TAG, "onExpiring");
//            }
//
//            @Override
//            public void onClosed(AdColonyInterstitial ad) {
//                super.onClosed(ad);
//
//                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                finish();
//            }
//        };
//
//        AdColony.requestInterstitial(ZONE_ID, listener, adOptions);

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            utils.animationhash();
            utils.beautyhash();
            utils.fashionhash();
            utils.gaminghash();
            utils.gymhash();
            utils.holihash();
            utils.memehash();
            utils.sportsfitnesshash();
            utils.tiktokhash();
            utils.travelhash();
            utils.photographyhash();
            utils.catfill();
            utils.yogahash();
            utils.workhash();
            utils.weddinghash();
            utils.tattooshash();
            utils.summerhash();
            utils.snowhash();
            utils.snapchathash();
            utils.skatinghash();
            utils.shoppinghash();
            utils.selfiehash();
            utils.runninghash();
            utils.readinghash();
            utils.rainhash();
            utils.pubghash();
            utils.photographerhash();
            utils.musichash();
            utils.movieshash();
            utils.motivationhash();
            utils.moneyhash();
            utils.minecrafthash();
            utils.makeuphash();
            utils.instalikehash();
            utils.jewelryhash();
            utils.horseshash();
            utils.hockeyhash();
            utils.hdrhash();
            utils.halloweenhash();
            utils.guitarhash();
            utils.gtavhash();
            utils.golfhash();
            utils.freefirehash();
            utils.fortnitehash();
            utils.footballhash();
            utils.foodhash();
            utils.followhash();
            utils.flowershash();
            utils.familyhash();
            utils.drawinghash();
            utils.dancerhash();
            utils.crickethash();
            utils.comedyhash();
            utils.collegehash();
            utils.coffeehash();
            utils.codinghash();
            utils.clashroyalehash();
            utils.clashofclanshash();
            utils.cityhash();
            utils.christmashash();
            utils.catshash();
            utils.carshash();
            utils.boxinghash();
            utils.bollywoodhash();
            utils.blackandwhitehash();
            utils.birthdayhash();
            utils.bikeshash();
            utils.battlefieldhash();
            utils.basketballhash();
            utils.actorshash();
            utils.babieshash();
            utils.autumnhash();
            utils.architecturehash();
            utils.animeshash();
            utils.animalshash();
            utils.androidhash();
            utils.adventurehash();

            utils.yolo(getApplicationContext());
            utils.yolosub(getApplicationContext());
            utils.yolosave(getApplicationContext());

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

//                    if (ad != null)
//                    {
//                      ad.show();
//                    }else{
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();

//                    }


                }
            }, 2000);

        }
    }

}
