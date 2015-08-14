package com.thorrism.materialdesignskeleton.demo.Validators;

import com.thorrism.designtools.views.ShakeEditText;

import validators.Validator;

/**
 * Created by Lucas Crawford on 8/13/2015.
 */
public class PasswordValidator implements Validator {
    private ShakeEditText mEditText;

    public PasswordValidator(ShakeEditText edit) {
        mEditText = edit;
    }

    @Override
    public boolean validate() {
        return mEditText.getText().toString().length() > 5;
    }
}
