package com.heroes.pc.heroes1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.heroes.pc.heroes1.authentication.LogInActivity;
import com.heroes.pc.heroes1.groups.GroupsActivity;
import com.heroes.pc.heroes1.profile.ProfileActivity;
import com.heroes.pc.heroes1.socialities.SocialitiesActivity;

public class Games_MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String EMAIL = "Email";
    private String email_from_signUp;
    private TextView mAccountName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_base);

        Log.e("TAG", "inside main activity");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        mAccountName = (TextView) header.findViewById(R.id.AccountName);

        if (savedInstanceState == null) {

            if (getIntent().hasExtra(EMAIL)) {
                Bundle arguments = new Bundle();
                arguments.putAll(getIntent().getExtras());
                Log.e("FF", "string email is : " + email_from_signUp);
                SharedPreferences settings = this.getSharedPreferences(Constants.PREFS_EMAIL, 0); // 0 - for private mode
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("EMAIL", arguments.getString(EMAIL));
                editor.apply();
            }


        }


        SharedPreferences email = getSharedPreferences(Constants.PREFS_EMAIL, 0);
        email_from_signUp =email.getString("EMAIL", "");
        mAccountName.setText(email_from_signUp);



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
        getMenuInflater().inflate(R.menu.games, menu);
        return false;
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

        if (id == R.id.nav_Games) {
            if (findViewById(R.id.drawer_layout) == null){
                Intent intent = new Intent(this,Games_MainActivity.class);
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
            editor.putBoolean("hasLoggedIn",false);
            editor.apply();

            Intent login = new Intent(this,LogInActivity.class);
            startActivity(login);
            this.finish();

        } else if (id == R.id.nav_contact_us) {

            ContactUsDialogFragment fragment = new ContactUsDialogFragment();
            fragment.show(getFragmentManager(),"dialogContactUs");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
