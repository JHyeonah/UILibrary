package com.coinshot.uilibrary2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.coinshot.uilibrary2.databinding.ActivityBootstrapSecondBinding;

public class BootstrapSecondActivity extends AppCompatActivity {
    ActivityBootstrapSecondBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bootstrap_second);

        binding.sendEt.addTextChangedListener(textWatcher);
        binding.receiveEt.addTextChangedListener(textWatcher);

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(binding.sendEt.getText().toString());
                float f = Float.parseFloat(binding.receiveEt.getText().toString());

                if(i < 30000 || i > 3000000){
                    binding.sendEt.setError("송금 가능 금액은 3만~300만 KRW 입니다");
                    binding.receiveEt.setError("송금 가능 금액은 1000 ~ 90,000 PHP 입니다");
                }else if(f < 1000 || f > 90000){
                    binding.receiveEt.setError("송금 가능 금액은 1000 ~ 90,000 PHP 입니다");
                }else{
                    SharedPreferences pref = getSharedPreferences("prefBoot", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("send", binding.sendEt.getText().toString());
                    editor.putString("receive", binding.receiveEt.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), BootstrapThirdActivity.class);
                    startActivity(intent);
                }

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
