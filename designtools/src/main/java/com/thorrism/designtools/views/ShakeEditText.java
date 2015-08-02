package com.thorrism.designtools.views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import validators.Validator;

/**
 * Created by Lucas Crawford on 7/21/2015.
 */
public class ShakeEditText extends AppCompatEditText {
    private Validator mValidationListener;
    private TranslateAnimation mAnimation;

    public ShakeEditText(Context context) {
        super(context);
        init();
    }

    public ShakeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShakeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setValidationListener(Validator listener) {
        mValidationListener = listener;
    }

    public boolean checkValidInput() {
        if (!mValidationListener.validate()) {
            shakeView();
            mValidationListener.setInvalidError();
            return false;
        }
        return true;
    }

    private void init() {
        setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (EditorInfo.IME_ACTION_DONE == actionId) {
                    checkValidInput();
                }
                return false;
            }
        });

        //set animation
        mAnimation = new TranslateAnimation(0, 8, 0, 0);
        mAnimation.setInterpolator(new CycleInterpolator(5));
        mAnimation.setDuration(300);

    }

    public void shakeView() {
        setAnimation(mAnimation);
        post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();
            }
        });
    }

}
