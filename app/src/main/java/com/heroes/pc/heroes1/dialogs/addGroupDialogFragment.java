package com.heroes.pc.heroes1.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.heroes.pc.heroes1.Constants;
import com.heroes.pc.heroes1.R;
import com.heroes.pc.heroes1.groups.GroupsGridFragment;

/**
 * Created by pc on 4/28/2016.
 */
public class addGroupDialogFragment extends DialogFragment {

    final Firebase addtoFB_REF = new Firebase(Constants.FIREBASE_URL);
    private Button creat_group;
    private Button cancel_creation;
    private EditText group_name;
    private EditText doctor_name;

    private Dialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_dialog_view, container, false);
        creat_group = (Button)view.findViewById(R.id.BTN_creatGroup);
        cancel_creation = (Button)view.findViewById(R.id.BTN_cancel_addGroup);
        group_name = (EditText)view.findViewById(R.id.dialogGroupName);
        doctor_name= (EditText)view.findViewById(R.id.dialogDoctorName);
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

        creat_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Gname = group_name.getText().toString();
                String Dname = doctor_name.getText().toString();
                if(!(Gname.isEmpty()||Dname.isEmpty()) ){
                    Firebase Ref = addtoFB_REF.child("groups").child("group_"+GroupsGridFragment.childrenCount+1).child("name");
                    Ref.setValue(Gname);
                    Ref = addtoFB_REF.child("groups").child("group_"+GroupsGridFragment.childrenCount+1).child("doctor");
                    Ref.setValue(Dname);
                    Ref = addtoFB_REF.child("groups").child("group_"+ GroupsGridFragment.childrenCount+1).child("members");
                    Ref.setValue("**group members**");
                    Ref = addtoFB_REF.child("groups").child("group_"+GroupsGridFragment.childrenCount+1).child("games");
                    Ref.setValue("**group games**");
                    Ref = addtoFB_REF.child("groups").child("group_"+GroupsGridFragment.childrenCount+1).child("performance");
                    Ref.setValue("**group performance**");
                    Ref = addtoFB_REF.child("groups").child("group_"+GroupsGridFragment.childrenCount+1).child("top_10");
                    Ref.setValue("**group top 10**");
                    Snackbar.make(v, "Group Added Successfully", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    dismiss();
                }else {
                    Toast.makeText(getActivity(),"Data is missing",Toast.LENGTH_SHORT).show();
                }

                     }
        });

        cancel_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}