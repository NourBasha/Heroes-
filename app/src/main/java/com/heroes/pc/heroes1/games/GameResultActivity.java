package com.heroes.pc.heroes1.games;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.Games_MainActivity;
import com.heroes.pc.heroes1.R;

public class GameResultActivity extends AppCompatActivity {
    TextView Points;
    TextView AvgTime;
    TextView Acc;

    Button btn_playAgain;
    Button btn_exit;

    private final String ACCURACY = "Accuracy";
    private final String POINTS = "Points";
    private final String TIME = "Time";

    private String accuracy;
    private String time;
    private String points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_results);
        Points=(TextView) findViewById(R.id.points);
        AvgTime=(TextView) findViewById(R.id.Avg);
        Acc=(TextView) findViewById(R.id.accuracy);

        btn_playAgain = (Button) findViewById(R.id.playAgain);
        btn_exit = (Button) findViewById(R.id.ExitGame);

        if(savedInstanceState==null){
            Intent intent = getIntent();
            accuracy = intent.getStringExtra(ACCURACY);
            time = intent.getStringExtra(TIME);
            points = intent.getStringExtra(POINTS);

            Points.setText(points);
            AvgTime.setText(time+" Sec");
            Acc.setText(accuracy+"%");

            SharedPreferences gameStaTstistics = this.getSharedPreferences(Constants.PREFS_GameData, 0); // 0 - for private mode
            SharedPreferences.Editor editor = gameStaTstistics.edit();
            editor.putString(ACCURACY,accuracy);
            editor.putString(POINTS, points);
            editor.putString(TIME, time);
            editor.apply();
        }



        btn_playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(GameResultActivity.this, GameActivity.class);
                startActivity(game);
                GameResultActivity.this.finish();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(GameResultActivity.this, Games_MainActivity.class);
                startActivity(game);
                GameResultActivity.this.finish();
            }
        });




    }
}
