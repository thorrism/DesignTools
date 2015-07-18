package com.thorrism.materialdesignskeleton.demo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.thorrism.designtools.views.MaterialDialog;
import com.thorrism.designtools.views.RaisedButton;
import com.thorrism.designtools.views.SquareImageView;
import com.thorrism.materialdesignskeleton.R;

public class DemoActivity extends AppCompatActivity {
    private RaisedButton mRaisedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mRaisedBtn = (RaisedButton) findViewById(R.id.raised_btn);
        addListeners();
    }

    /**
     * Adding click listeners to example buttons.
     */
    public void addListeners() {
        mRaisedBtn.addClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDialog.with(getApplicationContext())
                        .setTitle(R.string.dialog_title)
                        .setBody("Show the SquareImageView?")
                        .setSubmitListener(new MaterialDialog.SubmitListener() {
                            @Override
                            public void onSubmit() {
                                AnimationDrawable anim = (AnimationDrawable) getResources().getDrawable(R.drawable.loading_animation);
                                final SquareImageView image = (SquareImageView) findViewById(R.id.square_image);
                                image.setPlaceHolder(anim);
                                Picasso.with(getApplicationContext())
                                        .load("http://img3.goodfon.su/original/1680x1050/5/c4/android-l-material-design-6558.jpg")
                                        .into(image, new Callback() {
                                            @Override
                                            public void onSuccess() {
                                                image.removePlaceHolder();
                                            }

                                            @Override
                                            public void onError() {
                                                image.removePlaceHolder();
                                            }
                                        });
                            }
                        }).show(getSupportFragmentManager(), "material_dialog");
            }
        });
    }

}
