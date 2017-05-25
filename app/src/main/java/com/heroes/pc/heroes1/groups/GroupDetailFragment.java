package com.heroes.pc.heroes1.groups;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.heroes.pc.heroes1.adapters.GroupsNDSocialitiesGridAdapter;
import com.heroes.pc.heroes1.R;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupDetailFragment extends Fragment {



    private String group_name;
    private String doctor_name;
    private String group_memmbers;
    private String group_games;
    private String group_performance;
    private String group_top_ten;


    private final String GROUP_NAME = "Group_Name";
    private final String DOCTOR_NAME = "Doctor_Name";
    private final String GROUP_MEMBERS = "Group_Memebers";
    private final String GROUP_GAMES = "Group_Games";
    private final String GROUP_PERFORMANCE = "Group_Performance";
    private final String GROUP_TOP_TEN = "Group_Top_Ten";


    private GridView gridview;
    private GroupsNDSocialitiesGridAdapter mAdapter;
    private TextView txt_group_name ;
    private TextView txt_doctor_name ;
    private TextView txt_group_members;
    private TextView txt_group_games ;
    private TextView txt_group_performance ;
    private TextView txt_group_top_10;





    private Context context;
    public GroupDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.group_item_selected, container, false);


        txt_group_name = (TextView) rootView.findViewById(R.id.detail_group_name);
        txt_doctor_name = (TextView) rootView.findViewById(R.id.detail_doctor_name);
        txt_group_members = (TextView)rootView.findViewById(R.id.GroupMembers);
        txt_group_games = (TextView)rootView.findViewById(R.id.GroupGames);
        txt_group_performance = (TextView)rootView.findViewById(R.id.GroupPerformance);
        txt_group_top_10 = (TextView)rootView.findViewById(R.id.GroupTopTen);


        Bundle arguments = getArguments();


        if (arguments != null) {
            group_name = arguments.getString(GROUP_NAME);
            doctor_name = arguments.getString(DOCTOR_NAME);
            group_memmbers = arguments.getString(GROUP_MEMBERS);
            group_games = arguments.getString(GROUP_GAMES);
            group_performance = arguments.getString(GROUP_PERFORMANCE);
            group_top_ten = arguments.getString(GROUP_TOP_TEN);
        }


        txt_group_name.setText(group_name);
        txt_doctor_name.setText(doctor_name);
        txt_group_members.setText(group_memmbers);
        txt_group_games.setText(group_games);
        txt_group_performance.setText(group_performance);
        txt_group_top_10.setText(group_top_ten);



        return rootView;
    }
}
