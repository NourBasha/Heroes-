package com.example.pc.heroes1.authnitication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.heroes1.Constants;
import com.example.pc.heroes1.R;
import com.example.pc.heroes1.authnitication.LogInActivity;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by pc on 4/12/2016.
 */
public class SignUpFragment extends Fragment {


    private Context context;
    private Button signUp;
    private TextView email;
    private TextView password;
    private ImageView green;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sign_up_layout, container, false);

        email = (TextView) rootView.findViewById(R.id.email_signup);
        password = (TextView) rootView.findViewById(R.id.password_signup);
        signUp = (Button) rootView.findViewById(R.id.signUp_button);
        green = (ImageView)rootView.findViewById(R.id.green_light_signup);
//        forgotPassword = (TextView)rootView.findViewById(R.id.forgot_password_txtview);
//
//        button = (Button) rootView.findViewById(R.id.login_button);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Firebase ref = new Firebase(Constants.FIREBASE_URL);
                ref.createUser(email.getText().toString(), password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        Toast.makeText(getActivity(), "Welcome to HeRoes!", Toast.LENGTH_LONG).show();
                        Intent signin = new Intent(getActivity(),LogInActivity.class);
                        startActivity(signin);
                        getActivity().finish();
                        green.setVisibility(View.VISIBLE);

                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                        Log.e("TAG","error adding the account .. the error is "+firebaseError);

                    }
                });


//                //User has successfully logged in, save this information
//// We need an Editor object to make preference changes.
//                SharedPreferences settings = getActivity().getSharedPreferences(Constants.PREFS_NAME, 0); // 0 - for private mode
//                SharedPreferences.Editor editor = settings.edit();
////Set "hasLoggedIn" to true
//                editor.putBoolean("hasLoggedIn", true);
//// Commit the edits!
//                editor.apply();
//
//                Intent intent = new Intent(getActivity(),Games_MainActivity.class);
//                startActivity(intent);
//                getActivity().finish();


            }

        });




        return rootView;
    }




}
