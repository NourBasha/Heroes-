package com.example.pc.heroes1.groups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_detail_activity);


        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putAll( getIntent().getExtras());
            GroupDetailFragment fragment = new GroupDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.group_detail_container, fragment).commit();
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
