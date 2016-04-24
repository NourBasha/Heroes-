package com.example.pc.heroes1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupsNDSocialitiesGridAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private int mSource;
    private String[] mSocialitiesTiteles;

    public GroupsNDSocialitiesGridAdapter(Context context, int source) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        mSource=source;
    }

    public GroupsNDSocialitiesGridAdapter(Context context, int source,String[] titels) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        mSource=source;
        mSocialitiesTiteles = titels;
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }


    public int getCount() {

        if (mSource==1){
            return 10;
        }
        else if(mSource==2) {
            return mSocialitiesTiteles.length;
        }

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {

            if(mSource==1){
                holder = new ViewHolder();

                row = inflater.inflate(R.layout.group_name_grid_item, parent, false);
                holder.text1 = (TextView) row.findViewById(R.id.NameTextView);
                holder.text2 = (TextView) row.findViewById(R.id.DetailsTextView);


            }
            else {
                holder = new ViewHolder();

                row = inflater.inflate(R.layout.socialities_grid_item, parent, false);
                holder.imageView = (ImageView)row.findViewById(R.id.socialities_piture);
                holder.text1 = (TextView) row.findViewById(R.id.socialities_title);


                holder.text1.setText(mSocialitiesTiteles[position]);
            }




            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        return row;
    }

    static class ViewHolder {
        public ImageView imageView; // make static
        public TextView text1;
        public TextView text2;
    }

}
