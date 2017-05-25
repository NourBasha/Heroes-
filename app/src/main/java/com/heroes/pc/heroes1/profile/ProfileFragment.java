package com.heroes.pc.heroes1.profile;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.lists.FriendsListFragment;

/**
 * Created by pc on 4/8/2016.
 */
public class ProfileFragment  extends Fragment{

    private Context context;
    private Button button;
    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.profile, container, false);



        button = (Button) rootView.findViewById(R.id.friendsListButton);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                FriendsListFragment fragment1 = new FriendsListFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.profile_container, fragment1).commit();

            }

        });


        return rootView;
    }

}
