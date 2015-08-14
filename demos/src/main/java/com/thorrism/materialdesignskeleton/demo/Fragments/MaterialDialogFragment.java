package com.thorrism.materialdesignskeleton.demo.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thorrism.designtools.views.MaterialDialog;
import com.thorrism.materialdesignskeleton.R;


public class MaterialDialogFragment extends TabFragment {

    public MaterialDialogFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_material_dialog, container, false);
        v.findViewById(R.id.show_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        return v;
    }

    public void showDialog() {
        MaterialDialog.with(getActivity())
                .setTitle(R.string.dialog_title)
                .setBody("This is a material alert dialog. Dismiss with flat buttons below." +
                        "")
                .setSubmitListener(new MaterialDialog.SubmitListener() {
                    @Override
                    public void onSubmit() {

                    }
                }).show(getActivity().getSupportFragmentManager(), "material_dialog");
    }


}
