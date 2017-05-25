package com.heroes.pc.heroes1.games;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.heroes.pc.heroes1.R;

/**
 * Created by pc on 4/10/2016.
 */
public class GameDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_detail_activity);
        

        if (savedInstanceState == null) {

                Bundle arguments = new Bundle();
                arguments.putAll(getIntent().getExtras());
                if(!arguments.isEmpty()){
                    GameDetailsFragment fragment = new GameDetailsFragment();
                    fragment.setArguments(arguments);
                    getFragmentManager().beginTransaction()
                            .add(R.id.game_detail_container, fragment).commit();
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

}
