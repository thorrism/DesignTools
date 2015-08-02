package com.thorrism.materialdesignskeleton.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.thorrism.designtools.views.MaterialDialog;
import com.thorrism.designtools.views.ShakeEditText;
import com.thorrism.materialdesignskeleton.R;

import interfaces.FromXml;

public class DemoActivity extends AppCompatActivity {
    private ShakeEditText mShakeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mShakeEdit = (ShakeEditText) findViewById(R.id.name_edit);
        mShakeEdit.setValidationListener(new EmailValidator(mShakeEdit));
    }

    @FromXml
    public void checkEdit(View v) {
        if (mShakeEdit.checkValidInput()) {
            //valid input!
        }
    }

    @FromXml
    public void showDialog(View v) {
        MaterialDialog.with(getApplicationContext())
                .setTitle(R.string.dialog_title)
                .setBody("This is a material alert dialog. Dismiss with flat buttons below." +
                        "")
                .setSubmitListener(new MaterialDialog.SubmitListener() {
                    @Override
                    public void onSubmit() {

                    }
                }).show(getSupportFragmentManager(), "material_dialog");
    }
}
