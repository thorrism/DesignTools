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
public class FormView extends ScrollView {
    private ArrayList<ShakeEditText> mEditFields;

    public FormView(Context context){
        super(context);
        init();
    }

    public FormView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public FormView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mEditFields = new ArrayList<>();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public void onAttachedToWindow(){
        View child;
        ViewGroup parent = (ViewGroup) getChildAt(0);
        int count = parent.getChildCount();
        for(int i=0; i<count; ++i) {
            child = parent.getChildAt(i);
            if(child instanceof TextInputLayout)
                mEditFields.add( (ShakeEditText) ((TextInputLayout) child).getChildAt(0));
        }
    }

    /**
     * Validate every field in the form view.
     * @return true if all valid, false if one or more are not.
     */
    public boolean validateForm(){
        for(ShakeEditText se : mEditFields){
            if(!se.checkValidInput())
                return false;
        }
        return true;
    }

    /**
     * Listener for form view to scroll to a view on focus.
     *
     * TODO: Fix for API < 11. getY() issue. ( getBottom() ? )
     */
    public class ScrollListener implements OnFocusChangeListener{

        @Override
        public void onFocusChange(View v, boolean isFocus){
            if(Build.VERSION.SDK_INT >= 11 && isFocus) {
                int y = (int) v.getY();
                scrollTo(0, y);
            }

        }
    }
}
