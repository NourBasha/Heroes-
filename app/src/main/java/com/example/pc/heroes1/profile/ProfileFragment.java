package com.example.pc.heroes1.profile;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc.heroes1.lists.FriendsListFragment;
import com.example.pc.heroes1.authnitication.LogInActivity;
import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/8/2016.
 */
public class ProfileFragment  extends Fragment{

    private Context context;
    private Button button;
    private TextView title;
    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.profile, container, false);

        title = (TextView) rootView.findViewById(R.id.type_of_detail_profile_above);

        if(LogInActivity.language.equals("ar")){
            title.setText("الملف الشخصي");
        }else{
            title.setText("Profile");
        }


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
