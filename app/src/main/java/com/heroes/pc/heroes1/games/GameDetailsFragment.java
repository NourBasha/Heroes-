package com.heroes.pc.heroes1.games;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.R;
import com.squareup.picasso.Picasso;

/**
 * Created by pc on 4/9/2016.
 */
public class GameDetailsFragment extends Fragment {

    private String game_name;
    private String game_hardness;
    private String game_details;
    private String game_degree;
    private String game_performance;
    private int gamePosition;


    private final String GAME_NAME = "Game_Name";
    private final String GAME_HARDENSS = "Game_Hardness";
    private final String GAME_DETAILS = "Game_Details";
    private final String GAME_DEGREE = "Game_Degree";
    private final String GAME_PERFORMANCE = "Game_Performance";

    private final String ACCURACY = "Accuracy";
    private final String POINTS = "Points";
    private final String TIME = "Time";


    private TextView txt_game_name;
    private TextView txt_game_hardness;
    private TextView txt_game_details;

    private TextView txt_points;
    private TextView txt_accuracy;
    private TextView txt_time;

    private ProgressBar AccuracyProgress;
    private ProgressBar TimeProgress;
    private ProgressBar PointsProgress;

    private ImageView gameImage;

    private int avgTime;
    private  String gamePoints;
    private String accuracy;
    private float aFloat;



    private static Context context;
    private Button play ;


    public GameDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.game_item_selected, container, false);

        txt_game_name= (TextView) rootView.findViewById(R.id.GameName);
        txt_game_hardness = (TextView)rootView.findViewById(R.id.GameHardenss);
        txt_game_details = (TextView) rootView.findViewById(R.id.Game_Details);
        AccuracyProgress = (ProgressBar)rootView.findViewById(R.id.AccuracyProgress);
        TimeProgress = (ProgressBar)rootView.findViewById(R.id.AverageTimeProgress);
        PointsProgress = (ProgressBar)rootView.findViewById(R.id.PointsProgress);

        txt_points = (TextView) rootView.findViewById(R.id.GamePoints);
        txt_accuracy=(TextView) rootView.findViewById(R.id.GameAccuracyPercentage);
        txt_time = (TextView) rootView.findViewById(R.id.GameSeconds);

        play = (Button) rootView.findViewById(R.id.Game_play_button);
        gameImage = (ImageView) rootView.findViewById(R.id.DetailGameImage);


        Bundle arguments = getArguments();

        if (arguments != null){
            gamePosition = arguments.getInt("GAME");
            game_name = arguments.getString(GAME_NAME);
            game_hardness = arguments.getString(GAME_HARDENSS);
            game_details = arguments.getString(GAME_DETAILS);
            game_degree = arguments.getString(GAME_DEGREE);
            game_performance = arguments.getString(GAME_PERFORMANCE);
        }



        txt_game_name.setText(game_name);
        txt_game_hardness.setText(game_hardness);
        txt_game_details.setText(game_details);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(getActivity(),GameActivity.class);
                startActivity(game);

            }
        });

        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        if (gamePosition==0){
            Picasso.with(getActivity())
                    .load(R.drawable.ic_game_header)
                    .into(gameImage);

            SharedPreferences gameData = getActivity().getSharedPreferences(Constants.PREFS_GameData, 0);
            accuracy = gameData.getString(ACCURACY, "0");
            gamePoints= gameData.getString(POINTS,"0");
            aFloat = Float.parseFloat(gameData.getString(TIME,"0.0"));
            avgTime = Math.round(aFloat*100) ;

            //Accuracy
            AccuracyProgress.setIndeterminate(false);
            AccuracyProgress.setHovered(false);
            AccuracyProgress.setMax(100);
            AccuracyProgress.setProgress(Integer.parseInt(accuracy));
            txt_accuracy.setText(" "+accuracy+"%");
            //Time
            TimeProgress.setIndeterminate(false);
            TimeProgress.setHovered(false);
            TimeProgress.setMax(500);
            TimeProgress.setProgress(avgTime);
            txt_time.setText(" "+aFloat);
            //Points
            PointsProgress.setIndeterminate(false);
            PointsProgress.setHovered(false);
            PointsProgress.setMax(1000);
            PointsProgress.setProgress(Integer.parseInt(gamePoints));
            txt_points.setText(" "+gamePoints);

        }else {
            Picasso.with(getActivity())
                    .load(R.drawable.ic_game_header)
                    .into(gameImage);

            //Accuracy
            AccuracyProgress.setIndeterminate(false);
            AccuracyProgress.setHovered(false);
            AccuracyProgress.setMax(100);
            AccuracyProgress.setProgress(0);
            txt_accuracy.setText(" 0%");
            //Time
            TimeProgress.setIndeterminate(false);
            TimeProgress.setHovered(false);
            TimeProgress.setMax(180);
            TimeProgress.setProgress(0);
            txt_time.setText(" 0.0 Sec");
            //Points
            PointsProgress.setIndeterminate(false);
            PointsProgress.setHovered(false);
            PointsProgress.setMax(100);
            PointsProgress.setProgress(0);
            txt_points.setText(" 0");

            play.setEnabled(false);

        }
    }
}
