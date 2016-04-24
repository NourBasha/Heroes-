package com.example.pc.heroes1.groups;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.pc.heroes1.adapters.GroupsNDSocialitiesGridAdapter;
import com.example.pc.heroes1.authnitication.LogInActivity;
import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupsGridFragment extends Fragment {


    private final String GROUP_NAME = "Group_Name";
    private final String DOCTOR_NAME = "Doctor_Name";


    private GridView gridview;
    private GroupsNDSocialitiesGridAdapter mAdapter;
    private TextView group_name ;
    private TextView doctor_name ;
    private TextView title;

    private Context context;


    public GroupsGridFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        gridview = (GridView) rootView.findViewById(R.id.GridView);

        title = (TextView) rootView.findViewById(R.id.type_of_detail_grid_above);

        if(LogInActivity.language.equals("ar")){
            title.setText("المجموعات");
        }else{
            title.setText("Groups");
        }

        mAdapter = new GroupsNDSocialitiesGridAdapter(getActivity(),1); // 1 for group source, 2 for socialities source
        gridview.setAdapter(mAdapter);





        return rootView;

    }


    @Override
    public void onStart() {
        super.onStart();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),GroupDetailActivity.class);
                Bundle args = new Bundle();
                args.putString(GROUP_NAME, "lovers");
                args.putString(DOCTOR_NAME,"5ald tawfe2");
                intent.putExtras(args);
                startActivity(intent);




//   ((Callback) getActivity()).onItemSelected(i); for twopane tablet

//                ProfileFragment profile = new ProfileFragment();
//
//               getFragmentManager().beginTransaction()
//                       .add(profile, "sdad")
//                        .addToBackStack(null)
//                        .commit();

            }
        });
    }




    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(Intent intent);
    }
}
