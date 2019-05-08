package com.coinshot.uilibrary2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.coinshot.uilibrary2.adapter.TabAdapter;
import com.coinshot.uilibrary2.databinding.ActivitySmarttabBinding;
import com.coinshot.uilibrary2.fragment.PageoneFragment;
import com.coinshot.uilibrary2.fragment.PagethreeFragment;
import com.coinshot.uilibrary2.fragment.PagetwoFragment;

public class SmarttabActivity extends AppCompatActivity {
    ActivitySmarttabBinding binding;

    private TabAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_smarttab);

       adapter = new TabAdapter(getSupportFragmentManager());
       adapter.add("One", new PageoneFragment());
       adapter.add("Two", new PagetwoFragment());
       adapter.add("Three", new PagethreeFragment());

       binding.viewPager.setAdapter(adapter);
       binding.viewpagertab.setViewPager(binding.viewPager);

    }


}
