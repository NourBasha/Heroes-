package com.example.pc.heroes1.groups;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.pc.heroes1.adapters.GroupsNDSocialitiesGridAdapter;
import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupDetailFragment extends Fragment {



    private String group_name;
    private String doctor_name;
    private final String GROUP_NAME = "Group_Name";
    private final String DOCTOR_NAME = "Doctor_Name";


    private GridView gridview;
    private GroupsNDSocialitiesGridAdapter mAdapter;
    private TextView txt_group_name ;
    private TextView txt_doctor_name ;



    private Context context;
    public GroupDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.group_item_selected, container, false);


        txt_group_name = (TextView) rootView.findViewById(R.id.detail_group_name);
        txt_doctor_name = (TextView) rootView.findViewById(R.id.detail_doctor_name);


        Bundle arguments = getArguments();

        if (arguments != null) {
            group_name = arguments.getString(GROUP_NAME);
            doctor_name = arguments.getString(DOCTOR_NAME);
        }


        txt_group_name.setText(group_name);
        txt_doctor_name.setText(doctor_name);




        return rootView;
    }
}
