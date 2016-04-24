package com.example.pc.heroes1.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * A placeholder fragment containing a simple view.
 */
public class GamesGridFragment extends Fragment {


    private final String GAME_NAME = "Game_Name";
    private final String GAME_DETAILS = "Game_Details";

    private GridView gridview;
    private GamesNDProductsGridAdapter mGamesNDProductsGridAdapter;
    private TextView title;
    private ArrayList<GamesObject> gamesList;



    public GamesGridFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        gridview = (GridView) rootView.findViewById(R.id.GridView);
        title = (TextView) rootView.findViewById(R.id.type_of_detail_grid_above);

        if(LogInActivity.language.equals("ar")){
            title.setText("الالعاب");
        }else{
            title.setText("Games");
        }

        gamesList = new ArrayList<GamesObject>();
        mGamesNDProductsGridAdapter = new GamesNDProductsGridAdapter(getActivity(),gamesList,1,0 ); // 1 for games, 2 for products
        gridview.setAdapter(mGamesNDProductsGridAdapter);


        Firebase ref; ref = new Firebase(Constants.FIREBASE_URL+"/games");
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                gamesList.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    GamesListFromFireB game = postSnapshot.getValue(GamesListFromFireB.class);
                    GamesObject gamesObject = new GamesObject(game.getName(),game.getHardness());
                    gamesList.add(gamesObject);
                    Log.e("GG"," **ADDED** game name is : "+game.getName()+" - "+"game hardness : "+game.getHardness()+" \n");
                }
                mGamesNDProductsGridAdapter.setGridData(gamesList,1,0); // 1 for games, 2 for products
//                Log.e("TAG","the children are "+snapshot.getChildren());
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //  System.out.println("The read failed: " + firebaseError.getMessage());
                Log.e("GGG","  inside on cancelled ");
            }

        });


        // Attach an listener to read the data at our posts reference




//        Log.e("GGG","the size of th array list  is from the fragment "+gamesList.size());


        return rootView;

    }


    @Override
    public void onStart() {
        super.onStart();


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), GameDetailActivity.class);
                Bundle args = new Bundle();
                args.putString(GAME_NAME, gamesList.get(position).getGame_name());
                args.putString(GAME_DETAILS,gamesList.get(position).getGame_hardness());
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
