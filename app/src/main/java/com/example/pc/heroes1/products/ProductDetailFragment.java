package com.example.pc.heroes1.products;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.pc.heroes1.adapters.GamesNDProductsGridAdapter;
import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/10/2016.
 */
public class ProductDetailFragment extends Fragment {


    private String product_name;
    private String product_price;
    private String product_details;

    private final String PRODUCT_NAME = "Product_Name";
    private final String PRODUCT_PRICE = "Product_Price";
    private final String PRODUCT_DETAILS = "Product_details";



    private GridView gridview;
    private GamesNDProductsGridAdapter mGamesNDProductsGridAdapter;
    private TextView txt_product_name ;
    private TextView txt_product_price ;
    private TextView txt_product_details ;


    private Context context;


    public ProductDetailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.product_item_selected, container, false);

        txt_product_name = (TextView) rootView.findViewById(R.id.ProductName);
        txt_product_price = (TextView) rootView.findViewById(R.id.Price);
        txt_product_details= (TextView) rootView.findViewById(R.id.Product_Details);


        Bundle arguments = getArguments();

        if (arguments != null) {
            product_name = arguments.getString(PRODUCT_NAME);
            product_price = arguments.getString(PRODUCT_PRICE);
            product_details = arguments.getString(PRODUCT_DETAILS);
        }


        txt_product_name.setText(product_name);
        txt_product_price.setText(product_price);
        txt_product_details.setText(product_details);


        return rootView;

    }

    }
