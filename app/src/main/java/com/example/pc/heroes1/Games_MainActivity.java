package com.example.pc.heroes1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pc.heroes1.authnitication.LogInActivity;
import com.example.pc.heroes1.groups.GroupsActivity;
import com.example.pc.heroes1.products.ProductActivity;
import com.example.pc.heroes1.profile.ProfileActivity;
import com.example.pc.heroes1.socialities.SocialitiesActivity;

public class Games_MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_base);

        Log.e("TAG", "inside main activity");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       addGame();
                Snackbar.make(view, "Add Your Action Here", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    public void addGame(){
//
//        Firebase ref = new Firebase("https://heroes1.firebaseio.com");
//        ref.child("games").setValue("Game 1");
//
//    }


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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.games, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Games) {
            // Handle the games action

            if (findViewById(R.id.drawer_layout) == null){
                Intent intent = new Intent(this,Games_MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "You are here already", Toast.LENGTH_LONG).show();
            }


        } else if (id == R.id.nav_Products) {

            if (findViewById(R.id.product_container) == null){
                Intent intent = new Intent(this,ProductActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "You are here already", Toast.LENGTH_LONG).show();
            }

        } else if (id == R.id.nav_Groups) {

            if (findViewById(R.id.group_container) == null){
                Intent intent = new Intent(this,GroupsActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "You are here already", Toast.LENGTH_LONG).show();
            }

        } else if (id == R.id.nav_Profile) {


            if (findViewById(R.id.profile_container) == null){
                Intent intent = new Intent(this,ProfileActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "You are here already", Toast.LENGTH_LONG).show();
            }

        }
        else if (id == R.id.nav_Socialities) {

            if (findViewById(R.id.socialities_container) == null){
                Intent intent = new Intent(this,SocialitiesActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "You are here already", Toast.LENGTH_LONG).show();
            }

        }
        else if (id == R.id.nav_Log_out) {

            SharedPreferences settings = getSharedPreferences(Constants.PREFS_NAME, 0); // 0 - for private mode
            SharedPreferences.Editor editor = settings.edit();
            //Set "hasLoggedIn" to false
            editor.putBoolean("hasLoggedIn",false);
            // Commit the edits!
            editor.apply();
            Intent intent = new Intent(this, Games_MainActivity.class);
            this.finish();
            startActivity(intent);

            Intent login = new Intent(this,LogInActivity.class);
            startActivity(login);


        } else if (id == R.id.nav_contact_us) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
