package com.example.pc.heroes1.authnitication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/12/2016.
 */
public class SignUpActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);


        if (savedInstanceState == null) {
            //Bundle arguments = new Bundle();
            //  arguments.putAll( getIntent().getExtras());
            SignUpFragment fragment = new SignUpFragment();
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.sign_up_container, fragment).commit();
        }

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,LogInActivity.class);
        startActivity(intent);
        this.finish();
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
