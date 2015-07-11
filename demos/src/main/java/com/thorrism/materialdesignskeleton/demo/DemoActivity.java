package com.thorrism.materialdesignskeleton.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.thorrism.designtools.views.MaterialDialog;
import com.thorrism.designtools.views.RaisedButton;
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
                        .setBody(R.string.dialog_message)
                        .setSubmitListener(new MaterialDialog.SubmitListener() {
                            @Override
                            public void onSubmit() {
                                //do something here.
                                Toast.makeText(getApplicationContext(),
                                        "Submit Dialog.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }).show(getSupportFragmentManager(), "material_dialog");
            }
        });
    }

}
