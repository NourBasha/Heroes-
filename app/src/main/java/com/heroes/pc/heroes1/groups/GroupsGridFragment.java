package com.heroes.pc.heroes1.groups;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.adapters.GroupsNDSocialitiesGridAdapter;
import com.heroes.pc.heroes1.dialogs.addGroupDialogFragment;

import java.util.ArrayList;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupsGridFragment extends Fragment  {


    private final String GROUP_NAME = "Group_Name";
    private final String DOCTOR_NAME = "Doctor_Name";
    private final String GROUP_MEMBERS = "Group_Memebers";
    private final String GROUP_GAMES = "Group_Games";
    private final String GROUP_PERFORMANCE = "Group_Performance";
    private final String GROUP_TOP_TEN = "Group_Top_Ten";


    private GridView gridview;
    private FloatingActionButton fabAdd;
    public static long childrenCount;

    private EditText newGroup;
    private EditText newDoctor;





    private Context context;

    private GroupsNDSocialitiesGridAdapter groupsNDSocialitiesGridAdapter ;


    private ArrayList<GroupObject> groupList;


    public GroupsGridFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.groups_grid_view, container, false);


        final Firebase despDataFromFB_Ref = new Firebase(Constants.FIREBASE_URL+"/groups");

        gridview = (GridView) rootView.findViewById(R.id.groupsGridView);
        newGroup = (EditText) rootView.findViewById(R.id.dialogGroupName);
        newDoctor = (EditText)rootView.findViewById(R.id.dialogDoctorName);

        FloatingActionButton fabAdd =(FloatingActionButton) rootView.findViewById(R.id.fabAdd);



        groupList = new ArrayList<GroupObject>();
        groupsNDSocialitiesGridAdapter = new GroupsNDSocialitiesGridAdapter(getActivity(),1,groupList); // 1 for group source, 2 for socialities source
        gridview.setAdapter(groupsNDSocialitiesGridAdapter);


        despDataFromFB_Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                groupList.clear();
               childrenCount= snapshot.getChildrenCount();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    GroupsListFromFireB group = postSnapshot.getValue(GroupsListFromFireB.class);
                    GroupObject groupObject = new GroupObject(group.getDoctor(),
                            group.getName(),group.getMembers(),group.getGames(),group.getPerformance(),group.getTop_10());
                    groupList.add(groupObject);
                }
                groupsNDSocialitiesGridAdapter.setGridData(groupList);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });



        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });

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
                args.putString(GROUP_NAME, groupList.get(position).getGroup_name());
                args.putString(DOCTOR_NAME,groupList.get(position).getDoctor_name());
                args.putString(GROUP_MEMBERS,groupList.get(position).getGroup_members());
                args.putString(GROUP_GAMES,groupList.get(position).getGroup_games());
                args.putString(GROUP_PERFORMANCE,groupList.get(position).getGroup_performance());
                args.putString(GROUP_TOP_TEN,groupList.get(position).getGroup_top_ten());
                intent.putExtras(args);
                startActivity(intent);

            }
        });
    }

    public void showDialog() {
        addGroupDialogFragment fragment = new addGroupDialogFragment();
        fragment.show(getFragmentManager(),"dialog");
    }


}
