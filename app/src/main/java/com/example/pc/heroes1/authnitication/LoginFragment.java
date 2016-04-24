package com.example.pc.heroes1.authnitication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.heroes1.Constants;
import com.example.pc.heroes1.Games_MainActivity;
import com.example.pc.heroes1.R;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by pc on 4/12/2016.
 */


public class LoginFragment extends Fragment {



    private Context context;
    private Button login;
    private Button btn_signup;
    private TextView forgotPassword;

    private EditText edt_email;
    private EditText edt_password;



    public LoginFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.login_layout, container, false);

        forgotPassword = (TextView)rootView.findViewById(R.id.forgot_password_txtview);

        login = (Button) rootView.findViewById(R.id.login_button);
        btn_signup = (Button) rootView.findViewById(R.id.signUp_button_from_login);
        edt_email = (EditText) rootView.findViewById(R.id.edttxt_email_login);
        edt_password = (EditText) rootView.findViewById(R.id.edttxt_password_login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Firebase ref = new Firebase(Constants.FIREBASE_URL);

                ref.authWithPassword(edt_email.getText().toString(),edt_password.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {


                        Toast.makeText(getActivity(),"authentecated and logged in",Toast.LENGTH_LONG).show();

                        //User has successfully logged in, save this information
                        // We need an Editor object to make preference changes.
                        SharedPreferences settings = getActivity().getSharedPreferences(Constants.PREFS_NAME, 0); // 0 - for private mode
                        SharedPreferences.Editor editor = settings.edit();
                        //Set "hasLoggedIn" to true
                        editor.putBoolean("hasLoggedIn", true);
                        // Commit the edits!
                        editor.apply();

                        Intent intent = new Intent(getActivity(), Games_MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();

                    }
                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        // there was an error
                        Toast.makeText(getActivity(),"Error! the error is :"+firebaseError,Toast.LENGTH_LONG).show();
                    }
                });




            }

        });



        btn_signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
                getActivity().finish();


            }

        });



        return rootView;
    }





}
