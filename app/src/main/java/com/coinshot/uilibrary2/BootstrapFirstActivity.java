package com.coinshot.uilibrary2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapDropDown;
import com.coinshot.uilibrary2.databinding.ActivityBootstrapFirstBinding;

public class BootstrapFirstActivity extends AppCompatActivity {
    ActivityBootstrapFirstBinding binding;
    String sNation = "" ;
    String sHowto = "";
    String sBank = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bootstrap_first);

        binding.nationSpinner.setOnDropDownItemClickListener(new BootstrapDropDown.OnDropDownItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View v, int id) {
                String[] data = binding.nationSpinner.getDropdownData();
                sNation = data[id];
                binding.nationSpinner.setText(sNation);
            }
        });

        binding.howtoSpinner.setOnDropDownItemClickListener(new BootstrapDropDown.OnDropDownItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View v, int id) {
                String[] data = binding.howtoSpinner.getDropdownData();
                sHowto = data[id];
                binding.howtoSpinner.setText(sHowto);
            }
        });

        binding.bankSpinner.setOnDropDownItemClickListener(new BootstrapDropDown.OnDropDownItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View v, int id) {
                String[] data = binding.bankSpinner.getDropdownData();
                sBank = data[id];
                binding.bankSpinner.setText(sBank);
            }
        });


        binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !binding.accountEt.getText().toString().matches("([0-9]{11,16})") || !binding.nameEt.getText().toString().matches("([a-zA-Z]{2,35})")
                        || !binding.numberEt.getText().toString().matches("^01\\d{8,9}$") || sNation.trim().length() == 0 ||
                        sHowto.trim().length() == 0 || sBank.trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "항목들을 알맞게 입력해주세요." , Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences pref = getSharedPreferences("prefBoot", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("nation", binding.nationSpinner.getText().toString());
                    editor.putString("howto", binding.howtoSpinner.getText().toString());
                    editor.putString("bank", binding.bankSpinner.getText().toString());
                    editor.putString("account", binding.accountEt.getText().toString());
                    editor.putString("name", binding.nameEt.getText().toString());
                    editor.putString("phone", binding.numberEt.getText().toString());
                    if(binding.emailEt.getText().toString().length() != 0){
                        editor.putString("email", binding.emailEt.getText().toString());
                    }
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), BootstrapSecondActivity.class);
                    startActivity(intent);
                }
            }
        });

        textChanged();
    }
    public void textChanged(){
        binding.accountEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().matches("([0-9]{11,16})")){
                    binding.accountEt.setError("계좌번호는 11~16 자리 입니다.");
                }else if(s == null){
                    binding.accountEt.setError("필수 입력 항목입니다.");
                }
            }
        });

        binding.nameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s == null){
                    binding.nameEt.setError("필수 입력 항목입니다.");
                }else if(!s.toString().matches("([a-zA-Z]{2,35})")){
                    binding.nameEt.setError("영문명은 2자 이상 35자 이하입니다.");
                }
            }
        });

        binding.numberEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s == null){
                    binding.numberEt.setError("필수 입력 항목입니다.");
                }else if(!s.toString().matches("^01\\d{8,9}$")){
                    binding.numberEt.setError("올바른 번호를 입력하세요.");
                }
            }
        });

        binding.emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$")){
                    binding.emailEt.setError("올바른 이메일 형식을 입력하세요.");
                }
            }
        });
    }
}
