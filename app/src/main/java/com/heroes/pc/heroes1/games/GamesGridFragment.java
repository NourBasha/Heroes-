package com.heroes.pc.heroes1.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.adapters.GamesGridAdapter;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class GamesGridFragment extends Fragment {


    private final String GAME_NAME = "Game_Name";
    private final String GAME_HARDENSS = "Game_Hardness";
    private final String GAME_DETAILS = "Game_Details";
    private final String GAME_DEGREE = "Game_Degree";
    private final String GAME_PERFORMANCE = "Game_Performance";




    private GridView gridview;
    private GamesGridAdapter mGamesNDProductsGridAdapter;
    private ArrayList<GamesObject> gamesList;
    private LinearLayout linearLayout;




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
        linearLayout = (LinearLayout)rootView.findViewById(R.id.card_view_alpha);


        gamesList = new ArrayList<GamesObject>();
        mGamesNDProductsGridAdapter = new GamesGridAdapter(getActivity(),gamesList,1,0 ); // 1 for games, 2 for products
        gridview.setAdapter(mGamesNDProductsGridAdapter);


        Firebase ref = new Firebase(Constants.FIREBASE_URL+"/games");

        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                gamesList.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    GamesListFromFireB game = postSnapshot.getValue(GamesListFromFireB.class);
                    GamesObject gamesObject = new GamesObject(game.getName(),
                            game.getHardness(),game.getDetails(),game.getDegree(),game.getPerformance());
                    gamesList.add(gamesObject);
                }
                mGamesNDProductsGridAdapter.setGridData(gamesList,1,0); // 1 for games, 2 for products
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
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

                Intent intent = new Intent(getActivity(), GameDetailActivity.class);
                Bundle args = new Bundle();
                args.putString(GAME_NAME, gamesList.get(position).getGame_name());
                args.putString(GAME_HARDENSS,gamesList.get(position).getGame_hardness());
                args.putString(GAME_DETAILS,gamesList.get(position).getGame_details());
                args.putString(GAME_DEGREE,gamesList.get(position).getGame_degree());
                args.putString(GAME_PERFORMANCE,gamesList.get(position).getGame_performance());
                args.putInt("GAME",position);
                intent.putExtras(args);
                startActivity(intent);


            }
        });
    }




    public interface Callback {
        public void onItemSelected(Intent intent);
    }
}
