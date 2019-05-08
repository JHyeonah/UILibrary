package com.coinshot.uilibrary2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.coinshot.uilibrary2.databinding.ActivityMaterialThirdBinding;

public class MaterialThirdActivity extends AppCompatActivity {
    ActivityMaterialThirdBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_material_third);

        final SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

        binding.nationText.setText(pref.getString("nation", ""));
        binding.bankText.setText(pref.getString("bank", ""));
        binding.accountText.setText(pref.getString("account", ""));
        binding.nameText.setText(pref.getString("name", ""));
        binding.sendText.setText(pref.getString("send" , "") + " KRW");
        binding.receiveText.setText(pref.getString("receive", "") + " PHP");

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}
