package com.heroes.pc.heroes1.socialities;

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

import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.adapters.GroupsNDSocialitiesGridAdapter;

import java.util.Locale;

/**
 * Created by pc on 4/11/2016.
 */
public class SocialitiesGridFragment extends Fragment {


    private final String POSITION = "position";
    private GridView gridview;
    private GroupsNDSocialitiesGridAdapter mAdapter;
    private TextView txt_title ;
    private String[] mTitlesArray;
    private Context context;


    public SocialitiesGridFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        String lang = Locale.getDefault().getLanguage();

        if (lang.equals("ar")){
            mTitlesArray = new String[] {"الرسائل","الاداء","المستخدمين","الاحداث","الأطباء","الاعدادات"};
        }else{
            mTitlesArray = new String[] {"Messages","Performance","Users","Events","Doctors","Settings"};
        }

        gridview = (GridView) rootView.findViewById(R.id.GridView);



        mAdapter = new GroupsNDSocialitiesGridAdapter(getActivity(),2,mTitlesArray); // 1 for group source, 2 for socialities source
        gridview.setAdapter(mAdapter);

        return rootView;

    }


    @Override
    public void onStart() {
        super.onStart();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),SoclalitiesDetailsActivity.class);
                Bundle args = new Bundle();
                args.putInt(POSITION, position);
                intent.putExtras(args);
                startActivity(intent);



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
