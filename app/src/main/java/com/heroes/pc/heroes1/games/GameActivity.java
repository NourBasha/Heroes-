package com.heroes.pc.heroes1.games;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.heroes.pc.heroes1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity  {

    private final String ACCURACY = "Accuracy";
    private final String POINTS = "Points";
    private final String TIME = "Time";

    static int I1=0;
    static int I2 =0;
    static int OP=1;
    TextView txt1;
    TextView txt2;
    ImageView imgAdd;
    ImageView imgSub;
    ImageView imgDiv;
    ImageView imgMul ;
    ImageView truepic;
    ImageView falsepic ;
    int index;
    ArrayList<Integer> resultTime = new ArrayList<Integer>();
    ArrayList<Integer> resultPeriod = new ArrayList<Integer>();
    int resultTrue;
    int resultFalse;

    TextView time;


    long starttime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedtime = 0L;
    int t = 1;
    int secs = 0;
    int mins = 0;
    int milliseconds = 0;
    private Intent intentx;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        index=20;
        resultTrue=0;
        resultFalse=0;
        starttime = SystemClock.uptimeMillis();
        handler.postDelayed(updateTimer, 0);
         txt1=(TextView) findViewById(R.id.textView);
         txt2=(TextView) findViewById(R.id.textView2);
        time=(TextView) findViewById(R.id.Time);
         imgAdd = (ImageView) findViewById(R.id.adding);
         imgSub = (ImageView) findViewById(R.id.subtraction);
         imgDiv = (ImageView) findViewById(R.id.division);
         imgMul = (ImageView) findViewById(R.id.multiplication);
        truepic=(ImageView) findViewById(R.id.truepic);
        falsepic=(ImageView) findViewById(R.id.falsepic);





        final Random r = new Random();

        getRandumNumbers();
        updateText(I1, I2, OP);


        imgAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                UpdateResults(Check(1), timeInMilliseconds / 100);
                if(index==0)
                    goToResult();
                getRandumNumbers();
                updateText(I1, I2, OP);

            }
        });
        imgSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                UpdateResults(Check(2),timeInMilliseconds/100);
                if(index==0)
                    goToResult();
                getRandumNumbers();
                updateText(I1, I2, OP);


            }
        });


        imgMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                UpdateResults(Check(3),timeInMilliseconds/100);
                if(index==0)
                    goToResult();
                getRandumNumbers();
                updateText(I1, I2, OP);


            }
        });
        imgDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                UpdateResults(Check(4),timeInMilliseconds/100);
                if(index==0)
                    goToResult();
                getRandumNumbers();
                updateText(I1, I2, OP);

            }
        });


    }
    void updateText(int I1,int I2,int OP)
    {
        txt1.setText(""+I1);
        if(OP==1)
            txt2.setText(""+I2+"="+(I1+I2));
        else if (OP==2)
            txt2.setText(""+I2+"="+(I1-I2));
        else if (OP==3)
            txt2.setText(""+I2+"="+(I1*I2));
        else
            txt2.setText(""+I2+"="+(I1/I2));
    }
    public Runnable updateTimer = new Runnable()
    {

        public void run()
        {

            timeInMilliseconds = SystemClock.uptimeMillis() - starttime;

            updatedtime = timeSwapBuff + timeInMilliseconds;

            secs = (int) (updatedtime / 1000);
            mins = secs / 60;
            secs = secs % 60;
            milliseconds = (int) (updatedtime % 1000);
//            time.setText("" + mins + ":" + String.format("%02d", secs) + ":"
//                    + String.format("%03d", milliseconds));
            time.setText("" + mins + ":" + String.format("%02d", secs));
            handler.postDelayed(this, 0);
        }

    };
     void getRandumNumbers()
    {
        final Random r = new Random();
         I1 = r.nextInt(9)+1;
         I2 = r.nextInt(9)+1 ;
         OP = r.nextInt(4) + 1;
        if (OP>=4)
            I1=I1*I2;
    }
    String getOpSgn()
    {
        String x;
        if(OP==1)
            x="+";
        else if (OP==2)
            x="-";
        else if (OP==3)
            x="*";
        else
            x="/";
        return x;
    }
    void showTrue()
    {
        truepic.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                truepic.setVisibility(View.INVISIBLE);
            }
        }, 500);
    }
    void showFalse()
    {
        falsepic.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                falsepic.setVisibility(View.INVISIBLE);
            }
        }, 500);
    }
    boolean Check(int OP2)
    {
        int x,y;
        if (OP2==1)
            x=I1+I2;
        else if(OP2==2)
            x=I1-I2;
        else if (OP2==3)
            x=I1*I2;
        else
            x=I1/I2;


        if (OP==1)
            y=I1+I2;
        else if(OP==2)
            y=I1-I2;
        else if (OP==3)
            y=I1*I2;
        else
            y=I1/I2;

        if(x==y) {
            showTrue();
            return true;
        }
        else
        {
            showFalse();
            return false;
        }

    }
    void UpdateResults(boolean result,long mills)
    {
        if (result)
            resultTrue++;
        else
            resultFalse++;

        resultTime.add((int) mills);
        if(resultTime.size()==1)
            resultPeriod.add(resultTime.get(0));
        else
            resultPeriod.add(resultTime.get(resultTime.size()-1)-resultTime.get(resultTime.size()-2));

        index--;
    }
    void goToResult()
    {
        int acc= resultTrue*100/20;
        int AvgTime=calculateAverage(resultPeriod);
        int points=20*acc/AvgTime;
        Intent myIntent = new Intent(this, GameResultActivity.class);
        myIntent.putExtra(ACCURACY, "" + acc );
        myIntent.putExtra(POINTS, "" + points);
        myIntent.putExtra(TIME, "" + (float) AvgTime/10.0);
        this.startActivity(myIntent);
        this.finish();
    }
     int calculateAverage(List<Integer> Time) {
        int sum = 0;
        for (int i=0; i< Time.size(); i++) {
            sum += Time.get(i);
        }
        return sum / Time.size();
    }



}
