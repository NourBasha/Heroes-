package com.heroes.pc.heroes1.authentication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.Games_MainActivity;
import com.heroes.pc.heroes1.R;

import java.util.Locale;

/**
 * Created by pc on 4/12/2016.
 */
public class LogInActivity extends AppCompatActivity implements LoginFragment.callback{

    public static String language;
    public static Activity mActivity;
    private ProgressDialog progressDialog;

    public LogInActivity(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
       language= Locale.getDefault().getLanguage();

        SharedPreferences settings = getSharedPreferences(Constants.PREFS_NAME, 0);
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        if(hasLoggedIn)
        {
            Intent intent = new Intent(this,Games_MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        else {

            setContentView(R.layout.login_activity);

            if (savedInstanceState == null) {
                LoginFragment fragment = new LoginFragment();
                getFragmentManager().beginTransaction()
                        .add(R.id.login_container, fragment).commit();
            }
        }



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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



    @Override
    public void fireProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgressStyle(R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
    }

    @Override
    public void cancelProgressDialog() {
        progressDialog.dismiss();
    }
}


