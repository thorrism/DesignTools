package com.thorrism.materialdesignskeleton.demo.Validators;

import android.support.v7.widget.AppCompatEditText;

import validators.Validator;

/**
 * Created by Lucas Crawford on 8/1/2015.
 */
public class EmailValidator implements Validator {
    private AppCompatEditText mEditText;

    public EmailValidator(AppCompatEditText editText) {
        mEditText = editText;
    }

    @Override
    public boolean validate() {
        return mEditText.getText().toString().contains("@");
    }
}
