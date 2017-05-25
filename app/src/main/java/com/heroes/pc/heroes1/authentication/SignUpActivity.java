package com.heroes.pc.heroes1.authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.heroes.pc.heroes1.R;

/**
 * Created by pc on 4/12/2016.
 */
public class SignUpActivity extends AppCompatActivity implements SignUpFragment.callback {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);


        if (savedInstanceState == null) {
            SignUpFragment fragment = new SignUpFragment();
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.sign_up_container, fragment).commit();
        }

    }


    @Override
    public void onBackPressed() {
        this.finish();
        Intent intent = new Intent(this,LogInActivity.class);
        startActivity(intent);

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
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
    }

    @Override
    public void cancelProgressDialog() {
        progressDialog.dismiss();
    }
}
