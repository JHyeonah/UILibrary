package com.coinshot.uilibrary2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.coinshot.uilibrary2.databinding.ActivityDatePickerBinding;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    ActivityDatePickerBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_date_picker);

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                DatePickerActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "DatepickerDialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        String yearString = String.valueOf(year);
        String monthString = String.valueOf(monthOfYear + 1);
        String dayString = String.valueOf(dayOfMonth);
        String yearEndString = String.valueOf(yearEnd);
        String monthEndString = String.valueOf(monthOfYearEnd + 1);
        String dayEndString = String.valueOf(dayOfMonthEnd);
        String date = "선택한 기간: From - "+ yearString +"년 "+ monthString+  "월 " + dayString + "일," + " To - "+ yearEndString + "년 " + monthEndString + "월 " + dayEndString + "일";

        binding.textView.setText(date);
        Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
    }
}
