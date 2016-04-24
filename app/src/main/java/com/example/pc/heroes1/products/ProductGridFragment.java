package com.example.pc.heroes1.products;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.pc.heroes1.Constants;
import com.example.pc.heroes1.R;
import com.example.pc.heroes1.adapters.GamesNDProductsGridAdapter;
import com.example.pc.heroes1.authnitication.LogInActivity;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by pc on 4/10/2016.
 */
public class ProductGridFragment extends Fragment {

    private final String PRODUCT_NAME = "Product_Name";
    private final String PRODUCT_PRICE = "Product_Price";
    private final String PRODUCT_DETAILS = "Product_details";



    private GridView gridview;
    private GamesNDProductsGridAdapter mGamesNDProductsGridAdapter;
    private TextView product_name ;
    private TextView product_price ;
    private TextView title;
    private ArrayList<ProductObject> productList;

    private Context context;


    public ProductGridFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.grid_view, container, false);
        gridview = (GridView) rootView.findViewById(R.id.GridView);
        title = (TextView) rootView.findViewById(R.id.type_of_detail_grid_above);

        if(LogInActivity.language.equals("ar")){
            title.setText("المنتجات");
        }else{
            title.setText("Products");
        }

        productList = new ArrayList<ProductObject>();
        mGamesNDProductsGridAdapter = new GamesNDProductsGridAdapter(getActivity(),productList,2); // 1 for games , 2 for products
        gridview.setAdapter(mGamesNDProductsGridAdapter);

        Log.e("H"," inside products fragment");
        Firebase ref = new Firebase(Constants.FIREBASE_URL+"/products");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.e("H"," inside onDataChange");
                productList.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    ProductsListFromFireB prduct = postSnapshot.getValue(ProductsListFromFireB.class);
                    ProductObject productObject = new ProductObject(prduct.getName(),prduct.getPrice(),prduct.getDetails());
                    productList.add(productObject);
                    Log.e("GG"," **ADDED** game name is : "+prduct.getName()+" - "+"game hardness : "+prduct.getPrice()+" \n");
                }
                Log.e("H"," product list size is :"+ productList.size());
                mGamesNDProductsGridAdapter.setGridData(productList,2);  // 1 for games , 2 for products
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("H","  inside on cancelled the error is  : "+firebaseError);
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

                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                Bundle args = new Bundle();
                args.putString(PRODUCT_NAME,productList.get(position).getProduct_name());
                args.putString(PRODUCT_PRICE,productList.get(position).getProduct_price());
                args.putString(PRODUCT_DETAILS,productList.get(position).getProduct_details());
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
