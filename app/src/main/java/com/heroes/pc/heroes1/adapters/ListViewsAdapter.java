package com.heroes.pc.heroes1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heroes.pc.heroes1.R;

/**
 * Created by pc on 5/2/2016.
 */
public class ListViewsAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private Context mContext;
    private int mSource;

    public ListViewsAdapter(Context context, int source) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        mSource = source;
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }


    public int getCount() {


        return 10;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {

            holder = new ViewHolder();

            if (mSource==0){ // friends

                row = inflater.inflate(R.layout.list_item_mess_users_docs_friends, parent, false);
                holder.imageView = (ImageView)row.findViewById(R.id.list_item_picture);
                holder.text1 = (TextView) row.findViewById(R.id.list_item_text);
                holder.text1.setText("Friend Name");


            } else if (mSource == 1) { // messages
                row = inflater.inflate(R.layout.list_item_mess_users_docs_friends, parent, false);

                holder.imageView = (ImageView)row.findViewById(R.id.list_item_picture);
                holder.text1 = (TextView) row.findViewById(R.id.list_item_text);
                holder.text1.setText("Sender Name");

            } else if (mSource == 2){ // users

                row = inflater.inflate(R.layout.list_item_mess_users_docs_friends, parent, false);

                holder.imageView = (ImageView)row.findViewById(R.id.list_item_picture);
                holder.text1 = (TextView) row.findViewById(R.id.list_item_text);
                holder.text1.setText("Username");

            } else if (mSource==3){ // doctors

                row = inflater.inflate(R.layout.list_item_mess_users_docs_friends, parent, false);

                holder.imageView = (ImageView)row.findViewById(R.id.list_item_picture);
                holder.text1 = (TextView) row.findViewById(R.id.list_item_text);
                holder.text1.setText("Doctor Name");
            }
            else if (mSource==4){ // events

                row = inflater.inflate(R.layout.list_item_events, parent, false);

                holder.imageView = (ImageView)row.findViewById(R.id.list_item_event_picture);
                holder.text1 = (TextView) row.findViewById(R.id.list_item_event_name);
                holder.text2 = (TextView) row.findViewById(R.id.list_item_event_date);
                holder.text3 = (TextView) row.findViewById(R.id.list_item_event_timing);
                holder.text1.setText("Let's have fun!");
                holder.text2.setText("22/05/2017");
                holder.text3.setText("03:30 pm");

            }

            else if (mSource==5){ // performance

                row = inflater.inflate(R.layout.list_item_performance, parent, false);

                holder.imageView = (ImageView)row.findViewById(R.id.list_item_performance_picture);
                holder.text1 = (TextView) row.findViewById(R.id.list_item_game_name);
                holder.text2 = (TextView) row.findViewById(R.id.list_item_game_points);
                holder.text1.setText("sheko");
                holder.text2.setText("9/10");

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
        public TextView text3;

    }




}

