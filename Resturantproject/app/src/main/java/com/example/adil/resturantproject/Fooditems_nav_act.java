package com.example.adil.resturantproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Fooditems_nav_act extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean userclickonbackbutton=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.add(R.id.contentfooditem,new Punjabi_food());
        ft.commit();

        setContentView(R.layout.activity_fooditems_nav_act);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
    //    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      //  if (drawer.isDrawerOpen(GravityCompat.START)) {
        //    drawer.closeDrawer(GravityCompat.START);
            if (!userclickonbackbutton) {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
                userclickonbackbutton = true;
                //Toast.makeText(Fooditems_nav_act.this, "Logout Successfully...", Toast.LENGTH_SHORT).show();
            } else {
                super.onBackPressed();
            }
            new CountDownTimer(3000, 1000) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    userclickonbackbutton = false;
                }
            }.start();
//        }
//        else {
//            finish();
//            Toast.makeText(this, "logout successfully...", Toast.LENGTH_SHORT).show();
//            super.onBackPressed();
//        }
//    }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fooditems_nav_act, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Logout Successfully...", Toast.LENGTH_SHORT).show();
            finish();
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.punjabiman) {
            android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            Punjabi_food punjabi_food=new Punjabi_food();
            ft.replace(R.id.contentfooditem,punjabi_food);
            ft.commit();

        } else if (id == R.id.Snacks) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft=fragmentManager.beginTransaction();
            Snacks_fragment snacks_fragment=new Snacks_fragment();
            ft.replace(R.id.contentfooditem,snacks_fragment);
            ft.commit();

        } else if (id == R.id.sweets) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            sweets_fragment sweets_fragment=new sweets_fragment();
            ft.replace(R.id.contentfooditem,sweets_fragment);
            ft.commit();
        }else if (id == R.id.order) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.contentfooditem,new order());
            ft.commit();
        }
        else if (id == R.id.nav_share) {
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,"Hello...how are you.");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"Share..."));

        } else if (id == R.id.Feedback) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.contentfooditem,new Feedbackfragment());
            ft.commit();

        } else if (id == R.id.gallery) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.contentfooditem,new Gallery());
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
