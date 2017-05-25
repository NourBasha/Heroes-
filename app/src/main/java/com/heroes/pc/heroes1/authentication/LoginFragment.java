package com.heroes.pc.heroes1.authentication;

import android.app.Fragment;
import android.app.ProgressDialog;
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

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.Games_MainActivity;
import com.heroes.pc.heroes1.R;

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
    private Firebase ref;
    private Context mActivity;

    private final String EMAIL = "Email";


    private ProgressDialog progressDialog;

    public LoginFragment() {
    }

    public interface callback {
        void fireProgressDialog();
        void cancelProgressDialog();

    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.login_layout, container, false);

        mActivity = getActivity();

        ref = new Firebase(Constants.FIREBASE_URL);
        forgotPassword = (TextView)rootView.findViewById(R.id.forgot_password_txtview);

        login = (Button) rootView.findViewById(R.id.login_button);
        btn_signup = (Button) rootView.findViewById(R.id.signUp_button_from_login);
        edt_email = (EditText) rootView.findViewById(R.id.edttxt_email_login);
        edt_password = (EditText) rootView.findViewById(R.id.edttxt_password_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View arg0) {

                String email = edt_email.getText().toString();
                String pass= edt_password.getText().toString();

                if(!(email.isEmpty()||pass.isEmpty())){

                    ((callback) getActivity() ).fireProgressDialog();

                    ref.authWithPassword(edt_email.getText().toString(),edt_password.getText().toString(), new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(AuthData authData) {

                            Toast.makeText(getActivity(),"authenticated and logged in",Toast.LENGTH_LONG).show();
                            SharedPreferences settings = getActivity().getSharedPreferences(Constants.PREFS_NAME, 0); // 0 - for private mode
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putBoolean("hasLoggedIn", true);
                            editor.apply();

                            Intent intent = new Intent(getActivity(), Games_MainActivity.class);

                            Bundle email_to_navigation = new Bundle();
                            email_to_navigation.putString(EMAIL,edt_email.getText().toString());
                            intent.putExtras(email_to_navigation);
                            startActivity(intent);

                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            // On complete call either onLoginSuccess or onLoginFailed
                                            login.setEnabled(true);
                                            ((callback)getActivity() ).cancelProgressDialog();
                                            getActivity().finish();
                                        }
                                    }, 3000);

                        }
                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            // there was an error
                            ((callback) getActivity()).cancelProgressDialog();
                            Toast.makeText(getActivity(),"E-mail or Password is incorrect",Toast.LENGTH_LONG).show();
                        }
                    });

                }else {
                    Toast.makeText(getActivity(),"Data is missing",Toast.LENGTH_SHORT).show();
                }



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

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity=null;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = context;
    }
}
