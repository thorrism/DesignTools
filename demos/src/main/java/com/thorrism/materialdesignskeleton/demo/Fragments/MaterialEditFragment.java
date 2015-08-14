package com.thorrism.materialdesignskeleton.demo.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thorrism.designtools.views.FormView;
import com.thorrism.designtools.views.ShakeEditText;
import com.thorrism.materialdesignskeleton.R;

import com.thorrism.materialdesignskeleton.demo.DemoActivity;
import com.thorrism.materialdesignskeleton.demo.Validators.EmailValidator;
import com.thorrism.materialdesignskeleton.demo.Validators.NameValidator;
import com.thorrism.materialdesignskeleton.demo.Validators.PasswordValidator;

import validators.Validator;

/**
 * Created by Lucas Crawford on 8/13/2015.
 */
public class MaterialEditFragment extends TabFragment {
    private FormView mFormView;

    public MaterialEditFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shake_edit, container, false);
        setupForm(v);
        return v;
    }

    private void setupForm(View v) {
        mFormView = (FormView) v.findViewById(R.id.content_form);

        v.findViewById(R.id.submit_form_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEdit();
            }
        });

        //Add shake edit and listeners
        setupFields(v);
    }

    public void setupFields(View v) {
        final ShakeEditText mEmailEdit = (ShakeEditText) v.findViewById(R.id.email_edit);
        mEmailEdit.setValidationListener(new EmailValidator(mEmailEdit));

        final ShakeEditText mNameEdit = (ShakeEditText) v.findViewById(R.id.name_edit);
        mNameEdit.setValidationListener(new NameValidator(mNameEdit));

        final ShakeEditText mPasswordEdit = (ShakeEditText) v.findViewById(R.id.password_edit);
        mPasswordEdit.setValidationListener(new PasswordValidator(mPasswordEdit));

        final ShakeEditText mPasswordConfirmEdit = (ShakeEditText) v.findViewById(R.id.password_confirm_edit);
        mPasswordConfirmEdit.setValidationListener(new Validator() {
            @Override
            public boolean validate() {
                if (mPasswordConfirmEdit.getText().toString().length() < 4) {
                    mPasswordConfirmEdit.setDefaultError(getResources().getString(R.string.error_invalid_password));
                    return false;
                } else if (!mPasswordConfirmEdit.getText().toString().
                        equals(mPasswordEdit.getText().toString())) {
                    mPasswordConfirmEdit.setDefaultError(getResources().getString(R.string.error_invalid_password_match));
                    return false;
                }
                return true;
            }
        });
    }

    private void checkEdit() {
        if (mFormView.validateForm()) {
            ((DemoActivity) getActivity()).showSnackbar("Form is valid");
        }
    }
}
