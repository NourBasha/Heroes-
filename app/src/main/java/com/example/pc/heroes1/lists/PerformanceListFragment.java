package com.example.pc.heroes1.lists;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.heroes1.R;
import com.example.pc.heroes1.adapters.ListViewsAdapter;
import com.example.pc.heroes1.authnitication.LogInActivity;

/**
 * Created by pc on 4/11/2016.
 */
public class PerformanceListFragment extends Fragment {


    private Context context;
    private ListView listView;
    private TextView title;
    private ListViewsAdapter mListViewsAdapter;
    public PerformanceListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view_layout, container, false);

        listView = (ListView) rootView.findViewById(R.id.socialities_list_view_Details);
        title = (TextView) rootView.findViewById(R.id.type_of_detail_list_above);

        if(LogInActivity.language.equals("ar")){
            title.setText("الاداء");
        }else{
            title.setText("Performance");
        }
        mListViewsAdapter = new ListViewsAdapter(getActivity(),5); // 1) messages, 2)users, 3)doctors, 4) events, 5)performance

        listView.setAdapter(mListViewsAdapter);


        return rootView;
    }
}
