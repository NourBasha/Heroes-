package com.heroes.pc.heroes1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.games.GamesObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pc on 3/22/2016.
 */
public class GamesGridAdapter extends ArrayAdapter {


    private LayoutInflater inflater;
    private Context mContext;
    private ArrayList<GamesObject> gamesArrayList= new ArrayList<GamesObject>();
    private int size;
    private int dataType;

    public GamesGridAdapter(Context context, ArrayList<GamesObject> arrayList, int type, int nothing) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        dataType = type;
            gamesArrayList = arrayList;
    }


    public void setGridData(ArrayList<GamesObject> arrayList, int type, int nothing) {
        dataType = type;
        gamesArrayList = arrayList;
        notifyDataSetChanged();
    }


    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }


    public int getCount() {

        if(dataType==1){ // games
            return gamesArrayList.size();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder= new ViewHolder();

        if (row == null) {
                row = inflater.inflate(R.layout.game_card_view, parent, false);
                holder.imageView = (ImageView) row.findViewById(R.id.card_view_image);
                holder.text1 = (TextView) row.findViewById(R.id.card_view_name);
                holder.text2 = (TextView) row.findViewById(R.id.card_view_details);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        if(dataType==1){ // games
            if(position==0){
                Picasso.with(mContext)
                        .load(R.drawable.ic_game_header)
                        .into(holder.imageView);

            }else {
                Picasso.with(mContext)
                        .load(R.drawable.ic_game_header)
                        .into(holder.imageView);
            }

            holder.text1.setText(gamesArrayList.get(position).getGame_name());
            holder.text2.setText(gamesArrayList.get(position).getGame_hardness());
        }

        return row;
    }

    static class ViewHolder {
        public ImageView imageView;

        public TextView text1;
        public TextView text2;
    }





}
