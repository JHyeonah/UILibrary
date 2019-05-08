package com.coinshot.uilibrary2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.coinshot.uilibrary2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Button materialBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Button.OnClickListener ocListener = new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch (v.getId()){
                    case R.id.materialBtn:
                        intent = new Intent(getApplicationContext(), MaterialFirstActivity.class);
                        break;
                    case R.id.bootstrapBtn:
                        intent = new Intent(getApplicationContext(), BootstrapFirstActivity.class);
                        break;
                    case R.id.datePickerBtn:
                        intent = new Intent(getApplicationContext(), DatePickerActivity.class);
                        break;
                    case R.id.expandableBtn:
                        intent = new Intent(getApplicationContext(), ExpandableActivity.class);
                        break;
                    case R.id.smartTabBtn:
                        intent = new Intent(getApplicationContext(), SmarttabActivity.class);
                        break;
                }
                startActivity(intent);
            }
        };

        binding.materialBtn.setOnClickListener(ocListener);
        binding.bootstrapBtn.setOnClickListener(ocListener);
        binding.datePickerBtn.setOnClickListener(ocListener);
        binding.expandableBtn.setOnClickListener(ocListener);
        binding.smartTabBtn.setOnClickListener(ocListener);

    }
}
