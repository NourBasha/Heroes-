package com.example.pc.heroes1.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.heroes1.R;
import com.example.pc.heroes1.games.GamesObject;
import com.example.pc.heroes1.products.ProductObject;

import java.util.ArrayList;

/**
 * Created by pc on 3/22/2016.
 */
public class GamesNDProductsGridAdapter extends ArrayAdapter {


    private LayoutInflater inflater;
    private Context mContext;
    private ArrayList<GamesObject> gamesArrayList;
    private ArrayList<ProductObject> productArrayList;
    private int size;
    private int dataType;

    public GamesNDProductsGridAdapter(Context context, ArrayList<GamesObject> arrayList, int type,int nothing) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        dataType = type;
         // games
            gamesArrayList = arrayList;

    }

    public GamesNDProductsGridAdapter(Context context, ArrayList<ProductObject> arrayList, int type) {
        super(context, 0);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        dataType = type;
        productArrayList = arrayList;


    }

    public void setGridData(ArrayList<GamesObject> arrayList, int type, int nothing) {
        dataType = type;
        gamesArrayList = arrayList;
        notifyDataSetChanged();
    }

    public void setGridData(ArrayList<ProductObject> arrayList, int type) {
        dataType = type;
        productArrayList = arrayList;
        notifyDataSetChanged();
    }
    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }


    public int getCount() {

        if(dataType==1){ // games
            return gamesArrayList.size();
        }else if (dataType==2){ // products
            return productArrayList.size();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder= new ViewHolder();

        Log.e("GG","iteration num : "+position);

        if (row == null) {
                row = inflater.inflate(R.layout.grid_item_for_games_and_products, parent, false);
                holder.imageView = (ImageView) row.findViewById(R.id.GameNDProductPicture);
                holder.text1 = (TextView) row.findViewById(R.id.NameTextView);
                holder.text2 = (TextView) row.findViewById(R.id.DetailsTextView);
            row.setTag(holder);
        } else {
            Log.e("GG","iteration num : "+position+"  - inside ELSE ");
            holder = (ViewHolder) row.getTag();
        }


        if(dataType==1){ // games
            holder.text1.setText(gamesArrayList.get(position).getGame_name());
            holder.text2.setText(gamesArrayList.get(position).getGame_hardness());
        }else if (dataType==2){ // products
            holder.text1.setText(productArrayList.get(position).getProduct_name());
            holder.text2.setText(productArrayList.get(position).getProduct_price());
        }


        return row;
    }

    static class ViewHolder {
        public ImageView imageView; // make static
        public TextView text1;
        public TextView text2;
    }





}
