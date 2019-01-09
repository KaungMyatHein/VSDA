package com.pthlab.kaungmyat.vsda.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pthlab.kaungmyat.vsda.Fragments.PlantFragment;
import com.pthlab.kaungmyat.vsda.Fragments.PostPlantFragment;
import com.pthlab.kaungmyat.vsda.R;
import com.pthlab.kaungmyat.vsda.Fragments.PrePlantFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //VARIABLE DECLARATION
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private PrePlantFragment prePlantFragment;
    private PlantFragment plantFragment;
    private PostPlantFragment postPlantFragment;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawer.closeDrawers();
                int id = menuItem.getItemId();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                if (id == R.id.home) {
                } else if (id == R.id.detect_location) {
                    Intent feedbackIntent= new Intent(MainActivity.this,LocationActivity.class);
                    startActivity(feedbackIntent);
                }else if (id == R.id.about_app)
                {

                } else if (id == R.id.about_developer)
                {

                } else if (id == R.id.nav_share)
                {
                    shareApp();
                } else if (id == R.id.feedback)
                {
                    Intent feedbackIntent= new Intent(MainActivity.this,FeedbackActivity.class);
                    startActivity(feedbackIntent);
                }
                return true;
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        prePlantFragment = new PrePlantFragment();
        fragmentTransaction.addToBackStack("xyz");
        fragmentTransaction.add(R.id.fragmentContainer,prePlantFragment);
        fragmentTransaction.commit();
        bottomNavigationView.setItemTextAppearanceActive(R.drawable.icons_leaf);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                if (id == R.id.pre_plant_navi)
                {
                    prePlantFragment = new PrePlantFragment();
                    fragmentTransaction.addToBackStack(null);
                    getSupportFragmentManager().popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    fragmentTransaction.add(R.id.fragmentContainer,prePlantFragment);
                } else if (id == R.id.plant_navi)
                {
                    plantFragment = new PlantFragment();
                    fragmentTransaction.addToBackStack(null);
                    getSupportFragmentManager().popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    fragmentTransaction.add(R.id.fragmentContainer,plantFragment);
                }else if (id == R.id.post_plant_navi)
                {
                    postPlantFragment = new PostPlantFragment();
                    fragmentTransaction.addToBackStack(null);
                    getSupportFragmentManager().popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    fragmentTransaction.add(R.id.fragmentContainer,postPlantFragment);
                }
                fragmentTransaction.commit();
                return  true;
            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {

        } else if (id == R.id.detect_location) {

        }else if (id == R.id.about_app)
        {

        } else if (id == R.id.about_developer)
        {

        } else if (id == R.id.nav_share)
        {

        } else if (id == R.id.feedback)
        {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {

        }else if (id == R.id.detect_location) {

        } else if (id == R.id.about_app)
        {
        } else if (id == R.id.about_developer)
        {

        } else if (id == R.id.nav_share)
        {

        } else if (id == R.id.feedback)
        {

        }
        return super.onOptionsItemSelected(item);
    }
    /****** 12/31/2018 BY HSS *******/
    //To do share function in here
    private  void shareApp(){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body from VSDA.";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
