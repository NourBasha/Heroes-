package com.example.pc.heroes1.authnitication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pc.heroes1.Constants;
import com.example.pc.heroes1.Games_MainActivity;
import com.example.pc.heroes1.R;

import java.util.Locale;

/**
 * Created by pc on 4/12/2016.
 */
public class LogInActivity extends AppCompatActivity {

    public static String language;
    public LogInActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("TAG", "inside login activity to check if i was logged in or not");

       language= Locale.getDefault().getLanguage();

        SharedPreferences settings = getSharedPreferences(Constants.PREFS_NAME, 0);
        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        if(hasLoggedIn)
        {
            //Go directly to main activity.
            Intent intent = new Intent(this,Games_MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        else {

            setContentView(R.layout.login_activity);

            if (savedInstanceState == null) {
                //Bundle arguments = new Bundle();
                //  arguments.putAll( getIntent().getExtras());
                LoginFragment fragment = new LoginFragment();
                //  fragment.setArguments(arguments);
                getFragmentManager().beginTransaction()
                        .add(R.id.login_container, fragment).commit();
            }
        }


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_main, menu);  commented
        return true;
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


}
