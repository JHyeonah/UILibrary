package com.coinshot.uilibrary2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.coinshot.uilibrary2.databinding.ActivityMaterialSecondBinding;

public class MaterialSecondActivity extends AppCompatActivity {
    ActivityMaterialSecondBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_material_second);

        binding.sendEt.setText("0");
        binding.receiveEt.setText("0");

        binding.sendEt.addTextChangedListener(textWatcher);
        binding.receiveEt.addTextChangedListener(textWatcher);

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("send", binding.sendEt.getText().toString());
                editor.putString("receive", binding.receiveEt.getText().toString());
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), MaterialThirdActivity.class);
                startActivity(intent);
            }
        });

        binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s != null && !s.toString().equals("")){
                if(binding.sendEt.isFocused()){

                    binding.receiveEt.removeTextChangedListener(textWatcher);
                    if(!s.toString().equals("")){
                        float change = Float.parseFloat(s.toString()) / 22;
                        binding.receiveEt.setText(String.format("%.2f",change));
                    }
                    binding.receiveEt.addTextChangedListener(textWatcher);

                }else if(binding.receiveEt.isFocused()){

                    binding.sendEt.removeTextChangedListener(textWatcher);
                    if(!s.toString().equals("")){
                        float change = Float.parseFloat(s.toString()) * 22;
                        binding.sendEt.setText(String.valueOf((int)change));
                    }
                    binding.sendEt.addTextChangedListener(textWatcher);

                }
            }
        }
    };
}
