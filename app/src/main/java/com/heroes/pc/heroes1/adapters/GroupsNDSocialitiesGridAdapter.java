package com.heroes.pc.heroes1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.groups.GroupObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pc on 4/11/2016.
 */
public class GroupsNDSocialitiesGridAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private int mSource;
    private String[] mSocialitiesTiteles;

    ArrayList<GroupObject> groupObjectsList = new ArrayList<GroupObject>() ;

    public GroupsNDSocialitiesGridAdapter(Context context, int source, ArrayList<GroupObject> arrayList) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        mSource=source;
        groupObjectsList = arrayList;
    }

    public GroupsNDSocialitiesGridAdapter(Context context, int source,String[] titels) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        mSource=source;
        mSocialitiesTiteles = titels;
    }

    public void setGridData(ArrayList<GroupObject> arrayList) {
        groupObjectsList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }


    public int getCount() {

        if (mSource==1){
            return groupObjectsList.size();
        }
        else if(mSource==2) {
            return mSocialitiesTiteles.length;
        }

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row == null) {

            if(mSource==1){
                row = inflater.inflate(R.layout.group_name_grid_item, parent, false);
                holder.imageView = (ImageView)row.findViewById(R.id.card_view_group_image);
                holder.text1 = (TextView) row.findViewById(R.id.Group_Name);
                holder.text2 = (TextView) row.findViewById(R.id.Doctor_Name);
            }
            else {
                row = inflater.inflate(R.layout.socialities_grid_item, parent, false);
                holder.imageView = (ImageView)row.findViewById(R.id.socialities_piture);
                holder.text1 = (TextView) row.findViewById(R.id.socialities_title);
                holder.text1.setText(mSocialitiesTiteles[position]);
            }


            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        if ( mSource ==1){
            Picasso.with(mContext)
                    .load(R.drawable.ic_group_item)
                    .into(holder.imageView);
            holder.text1.setText(groupObjectsList.get(position).getGroup_name());
            holder.text2.setText(groupObjectsList.get(position).getDoctor_name());

        } else {
            switch (position){
                case 0:
                    Picasso.with(mContext)
                            .load(R.drawable.masseges)
                            .into(holder.imageView);
                    break;
                case 1:
                    Picasso.with(mContext)
                            .load(R.drawable.performance)
                            .into(holder.imageView);
                    break;
                case 2:
                    Picasso.with(mContext)
                            .load(R.drawable.users)
                            .into(holder.imageView);
                    break;
                case 3:
                    Picasso.with(mContext)
                            .load(R.drawable.events)
                            .into(holder.imageView);
                    break;
                case 4:
                    Picasso.with(mContext)
                            .load(R.drawable.doctors)
                            .into(holder.imageView);

                    break;
                case 5:
                    Picasso.with(mContext)
                            .load(R.drawable.settings)
                            .into(holder.imageView);
                    break;
            }

        }


        return row;
    }

    static class ViewHolder {
        public ImageView imageView; // make static
        public TextView text1;
        public TextView text2;
    }

}
