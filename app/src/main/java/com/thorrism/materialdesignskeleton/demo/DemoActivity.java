package com.thorrism.materialdesignskeleton.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.thorrism.materialdesignskeleton.R;
import com.thorrism.materialdesignskeleton.views.RaisedButton;

public class DemoActivity extends AppCompatActivity {
    private RaisedButton mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mBtn = (RaisedButton) findViewById(R.id.raised_btn);
        mBtn.addClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                mBtn.setText("Pressed.");
            }
        });
    }

}
