package com.example.pc.heroes1.socialities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pc.heroes1.lists.DoctorsListFragment;
import com.example.pc.heroes1.lists.EventListFragment;
import com.example.pc.heroes1.lists.MessagesListFragment;
import com.example.pc.heroes1.lists.PerformanceListFragment;
import com.example.pc.heroes1.R;
import com.example.pc.heroes1.lists.UsersListFragment;

/**
 * Created by pc on 4/11/2016.
 */
public class SoclalitiesDetailsActivity extends AppCompatActivity {


    private final String POSITION = "position";
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socialities_detail_activity);

        if (savedInstanceState == null) {


            Bundle arguments = new Bundle();
            arguments.putAll(getIntent().getExtras());
            position = arguments.getInt(POSITION);


            switch (position){

                case 0: // messages

                    MessagesListFragment fragment0 = new MessagesListFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.socialities_detail_container, fragment0).commit();


                    break;
                case 1: // performance

                    PerformanceListFragment fragment1 = new PerformanceListFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.socialities_detail_container, fragment1).commit();

                    break;

                case 2: // Users

                    UsersListFragment fragment2 = new UsersListFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.socialities_detail_container, fragment2).commit();

                    break;

                case 3: // Events

                    EventListFragment fragment3 = new EventListFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.socialities_detail_container, fragment3).commit();

                    break;

                case 4: // Doctors

                    DoctorsListFragment fragment4 = new DoctorsListFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.socialities_detail_container, fragment4).commit();

                    break;

                case 5:  // Settings


                    break;

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
