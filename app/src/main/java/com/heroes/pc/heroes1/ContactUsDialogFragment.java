package com.heroes.pc.heroes1;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by pc on 5/2/2016.
 */
public class ContactUsDialogFragment extends DialogFragment {

    final Firebase addtoFB_REF = new Firebase(Constants.FIREBASE_URL);
    private Button submit_message;
    private Button cancel_message;
    private EditText message_title;
    private EditText message;

    private Dialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_us_dialog, container, false);
        submit_message = (Button)view.findViewById(R.id.BTN_Submit);
        cancel_message = (Button)view.findViewById(R.id.BTN_cancel_message);
        message_title = (EditText)view.findViewById(R.id.dialogMessageTitle);
        message = (EditText)view.findViewById(R.id.dialogMessage);
        return view ;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();

        submit_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Gname = message_title.getText().toString();
                String MessageContent = message.getText().toString();
                if(!(Gname.isEmpty()||MessageContent.isEmpty()) ){
                    Toast.makeText(getActivity(),"Thanks for your feedback!",Toast.LENGTH_SHORT).show();
                    dismiss();
                }else {
                    Toast.makeText(getActivity(),"Data is missing",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
