package com.heroes.pc.heroes1.groups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.heroes.pc.heroes1.R;

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


}
