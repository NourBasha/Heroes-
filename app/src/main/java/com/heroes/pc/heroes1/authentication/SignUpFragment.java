package com.heroes.pc.heroes1.authentication;

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
import android.widget.EditText;
import android.widget.Toast;

import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.Games_MainActivity;
import com.heroes.pc.heroes1.R;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by pc on 4/12/2016.
 */
public class SignUpFragment extends Fragment {


    private Context context;
    private Button signUp;
    private EditText email;
    private EditText password;
    private EditText username;
    private EditText date_of_birth;
    private EditText country;
    private EditText retype_password;

    private final Firebase ref = new Firebase(Constants.FIREBASE_URL);
    private final Firebase reference = new Firebase(Constants.FIREBASE_URL);
    private Firebase refUsers = new Firebase(Constants.FIREBASE_URL+"/users");
    private final String EMAIL = "Email";
    private final String ACCURACY = "Accuracy";
    private final String POINTS = "Points";
    private final String TIME = "Time";


    public SignUpFragment() {
    }

    public interface callback {
        void fireProgressDialog();
        void cancelProgressDialog();

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sign_up_layout, container, false);

        email = (EditText) rootView.findViewById(R.id.email_signup);
        password = (EditText) rootView.findViewById(R.id.password_signup);
        signUp = (Button) rootView.findViewById(R.id.signUp_button);
        country=(EditText)rootView.findViewById(R.id.edt_Country);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(!(email.getText().toString().isEmpty()||password.getText().toString().isEmpty()||country.getText().toString().isEmpty())){

                    ((callback) getActivity()).fireProgressDialog();

                    ref.createUser(email.getText().toString(), password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {

                            SharedPreferences settings = getActivity().getSharedPreferences(Constants.PREFS_NAME, 0); // 0 - for private mode
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putBoolean("hasLoggedIn", true);
                            editor.apply();

                            Toast.makeText(getActivity(), " Account created, Welcome to HeRoes!", Toast.LENGTH_LONG).show();
                            Intent games = new Intent(getActivity(),Games_MainActivity.class);

                            Bundle email_to_navigation = new Bundle();
                            email_to_navigation.putString(EMAIL,email.getText().toString());
                            games.putExtras(email_to_navigation);
                            startActivity(games);

                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            signUp.setEnabled(true);

                                            ((callback)getActivity()).cancelProgressDialog();
                                            getActivity().finish();
                                        }
                                    }, 3000);


                            SharedPreferences gameStastistics = getActivity().getSharedPreferences(Constants.PREFS_GameData, 0); // 0 - for private mode
                            SharedPreferences.Editor editor2 = gameStastistics.edit();
                            editor2.putString(ACCURACY,"0");
                            editor2.putString(POINTS, "0");
                            editor2.putString(TIME, "0.0");
                            editor2.apply();

                        }
                        @Override
                        public void onError(FirebaseError firebaseError) {
                            ((callback) getActivity()).cancelProgressDialog();
                            Log.e("GAT","error is :"+firebaseError);
                            Toast.makeText(getActivity(),"Error in creating new account, check your entries",Toast.LENGTH_LONG).show();

                        }
                    });
                }else {
                    Toast.makeText(getActivity(),"Data is missing",Toast.LENGTH_SHORT).show();
                }

            }

        });




        return rootView;
    }




}
