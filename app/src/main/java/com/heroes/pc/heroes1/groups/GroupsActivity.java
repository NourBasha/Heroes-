package com.heroes.pc.heroes1.groups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.heroes.pc.heroes1.R;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);

        if (savedInstanceState == null) {
            GroupsGridFragment fragment = new GroupsGridFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.group_container, fragment).commit();
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
