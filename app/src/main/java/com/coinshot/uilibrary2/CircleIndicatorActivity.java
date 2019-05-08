package com.coinshot.uilibrary2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.coinshot.uilibrary2.adapter.TabAdapter;
import com.coinshot.uilibrary2.databinding.ActivityCircleindicatorBinding;
import com.coinshot.uilibrary2.fragment.PageoneFragment;
import com.coinshot.uilibrary2.fragment.PagethreeFragment;
import com.coinshot.uilibrary2.fragment.PagetwoFragment;

public class CircleIndicatorActivity extends AppCompatActivity {
    ActivityCircleindicatorBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_circleindicator);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.add("", new PageoneFragment());
        adapter.add("", new PagetwoFragment());
        adapter.add("", new PagethreeFragment());

        //binding
    }
}
