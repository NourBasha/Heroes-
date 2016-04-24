package com.example.pc.heroes1.games;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.heroes1.R;

/**
 * Created by pc on 4/9/2016.
 */
public class GameDetailsFragment extends Fragment {

    private String game_name;
    private String game_details;
    private final String GAME_NAME = "Game_Name";
    private final String GAME_DETAILS = "Game_Details";

    private TextView txt_game_name;
    private TextView txt_game_details;


    private static Context context;
    private Button play ;


    public GameDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.game_item_selected, container, false);

      // final Firebase ref = new Firebase("https://heroes1.firebaseio.com/");

        txt_game_name= (TextView) rootView.findViewById(R.id.GameName);
        txt_game_details = (TextView) rootView.findViewById(R.id.Game_Details);
        play = (Button) rootView.findViewById(R.id.Game_play_button);

        Bundle arguments = getArguments();

        if (arguments != null){
            game_name = arguments.getString(GAME_NAME);
            game_details = arguments.getString(GAME_DETAILS);
        }


        txt_game_name.setText(game_name);
        txt_game_details.setText(game_details);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                for(int i =6;i<11;i++){
//                    Firebase alanRef = ref.child("games").child("game "+i).child("name");
//                    alanRef.setValue("**game name**");
//                    alanRef = ref.child("games").child("game "+i).child("hardness");
//                    alanRef.setValue("**game hardness**");
//                }
//
//                alanRef = ref.child("games").child("game 1").child("details");
//                alanRef.setValue("this game increases your ability to simulate driving a car");
//                alanRef = ref.child("games").child("game 1").child("degree");
//                alanRef.setValue("7/10");
//                alanRef = ref.child("games").child("game 1").child("performance");
//                alanRef.setValue("performance details ( parent for further details )");

                Toast.makeText(getActivity()," Games Added!",Toast.LENGTH_LONG).show();

            }
        });



        return rootView;

    }


}
