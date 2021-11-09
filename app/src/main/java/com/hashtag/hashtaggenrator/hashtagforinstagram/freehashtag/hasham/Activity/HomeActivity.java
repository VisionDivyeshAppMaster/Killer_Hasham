package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Adepter.recyclemodel;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Search_Fragment;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.BuildConfig;
import com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.R;

import static com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.utils.yolo;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigation;
    public static ImageView sex,submit;
    public static GridView recyclerView;
    recyclemodel adapter;
    public static EditText inputsearch;
    public static TextView text;
    public static boolean check;

//    private final String APP_ID = "app801b6402e4b741ad8b";
//    private final String ZONE_ID = "vza6ef94e4656240dca5";
//    private final String TAG = "AdColonyDemo";
//    private AdColonyInterstitial ad;
//    private AdColonyInterstitialListener listener;
//    private AdColonyAdOptions adOptions;
//    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fainalmain);

        utils.maincontext = getApplicationContext();
        text = findViewById(R.id.text);
//        progress=findViewById(R.id.progress);

        //Interstitial ads of adColony
//        AdColonyAppOptions appOptions = new AdColonyAppOptions()
//                .setUserID("unique_user_id")
//                .setKeepScreenOn(true);
//
//        AdColony.configure(this, appOptions, APP_ID, ZONE_ID);

        // setup listener for interstitial ad callback.
        // you only need to implement the callback that you care about.

//        listener = new AdColonyInterstitialListener() {
//            @Override
//            public void onRequestFilled(AdColonyInterstitial ad) {
//                // Ad passed back in request filled callback, ad can now be shown
//                HomeActivity.this.ad = ad;
//
//                ad.show();
//                progress.setVisibility(View.INVISIBLE);
//                Log.d(TAG, "onRequestFilled");
//            }
//
//            @Override
//            public void onRequestNotFilled(AdColonyZone zone) {
//                // Ad request was not filled
//                progress.setVisibility(View.INVISIBLE);
//                Log.d(TAG, "onRequestNotFilled");
//            }
//
//            @Override
//            public void onOpened(AdColonyInterstitial ad) {
//                // Ad opened, reset UI to reflect state change
//
//                progress.setVisibility(View.VISIBLE);
//                Log.d(TAG, "onOpened");
//            }
//
//            @Override
//            public void onExpiring(AdColonyInterstitial ad) {
//                // Request a new ad if ad is expiring
//
//                progress.setVisibility(View.VISIBLE);
//                AdColony.requestInterstitial(ZONE_ID, this, adOptions);
//                Log.d(TAG, "onExpiring");
//            }
//
//            @Override
//            public void onClosed(AdColonyInterstitial ad) {
//                super.onClosed(ad);
//            }
//        };


//        if (ad == null)
//        {
////            progress.setVisibility(View.VISIBLE);
//            AdColony.requestInterstitial(ZONE_ID, listener, adOptions);
//
//        }else{
//            Toast.makeText(getApplicationContext(), "ads fail....", Toast.LENGTH_SHORT).show();
//        }




        Log.e("sapata","Main Activity");

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        recyclerView = findViewById(R.id.classicrec);
        recyclerView.setNestedScrollingEnabled(true);
        adapter = new recyclemodel(utils.carshash);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(getApplicationContext(), BioActivity.class));

                    utils.biotext = String.valueOf(utils.carshash.get(position));
                Log.e("TTTT","Mi---tag>"+ utils.biotext);
            }
        });

        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setVisibility(View.GONE);
                sex.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                inputsearch.setVisibility(View.VISIBLE);

                check = true;

                inputsearch.requestFocus();
                utils.key(getApplicationContext());

                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new Search_Fragment());
                fragmentTransaction.commit();

                inputsearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                        // When user changed the Text
                       Search_Fragment.adapter.getFilter().filter(cs);
                    }

                    @Override
                    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                  int arg3) {
                    }

                    @Override
                    public void afterTextChanged(Editable arg0) {
                    }
                });


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Activity.submit.class));
            }
        });

        yolo(getApplicationContext());

        utils.Maincontex = getApplicationContext();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_heart) {
                    Intent i = new Intent(getApplicationContext(), heart.class);
                    startActivity(i);
                    return true;
                }else if (item.getItemId() == R.id.nav_saved) {
                    Intent j = new Intent(getApplicationContext(), saved.class);
                    startActivity(j);
                }
                else if (item.getItemId() == R.id.nav_submit) {
                    Intent k = new Intent(getApplicationContext(), SubmitedActivity.class);
                    startActivity(k);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
            String shareMessage = getResources().getString(R.string.app_name) + "\n" + "Let me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } else if (id == R.id.nav_rateus) {
            Intent new_intent = Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)), "Share via");
            new_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(new_intent);
        }else if(id == R.id.about_us){
            Intent aboutus = new Intent(getApplicationContext(), Aboutus.class);
            startActivity(aboutus);
        }
        else if (id == R.id.nav_tuto) {
            Intent l = new Intent(getApplicationContext(), TutoActivity.class);
            startActivity(l);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init() {

        sex = findViewById(R.id.sex);
        submit = findViewById(R.id.submit);

        inputsearch = findViewById(R.id.inputSearch);

        bottomNavigation = findViewById(R.id.bottom_navigation);

    }

    @Override
    public void recreate() {
            startActivity(getIntent());
            finish();

    }
}
