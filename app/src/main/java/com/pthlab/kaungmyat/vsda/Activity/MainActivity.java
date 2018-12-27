package com.pthlab.kaungmyat.vsda.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        prePlantFragment = new PrePlantFragment();
        fragmentTransaction.addToBackStack("xyz");
        fragmentTransaction.add(R.id.fragmentContainer,prePlantFragment);
        fragmentTransaction.commit();
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
        } else if (id == R.id.about_app)
        {

        } else if (id == R.id.about_developer)
        {

        } else if (id == R.id.nav_share)
        {

        } else if (id == R.id.feedback)
        {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
