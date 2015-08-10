package com.thorrism.designtools.views;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Lucas Crawford on 8/6/2015.
 */
public class FormView extends LinearLayout {
    private ArrayList<ShakeEditText> mEditFields;

    public FormView(Context context) {
        super(context);
        init();
    }

    public FormView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FormView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mEditFields = new ArrayList<>();
    }
    
    /**
     * When the view is attached to the window, find all Validators and add them to
     * our validator list.
     */
    @Override
    public void onAttachedToWindow() {
        View child;
        int count = getChildCount();
        for (int i = 0; i < count; ++i) {
            child = getChildAt(i);
            if (child instanceof TextInputLayout){
                View edit = child.getChildAt(0);
                if(edit instanceof Validator)
                    mEditFields.add((Validator) edit);
            }
            else
                if(child instanceof Validator)
                    mEditFields.add( (Validator) child);
        }
    }

    /**
     * Validate every field in the form view.
     *
     * @return true if all valid, false if one or more are not.
     */
    public boolean validateForm() {
        for (ShakeEditText se : mEditFields) {
            if (!se.checkValidInput())
                return false;
        }
        return true;
    }
}
