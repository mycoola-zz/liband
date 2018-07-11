package com.libandexample;

import com.liband.BaseActivity;
import com.liband.utils.DrawablesUtil;
import com.libandexample.databinding.ActivityMainBinding;

import android.databinding.DataBindingUtil;

public class MainActivity extends BaseActivity {
    ActivityMainBinding activityMainBinding;


    @Override
    public void initView() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        startAnotherActivity(Main2Activity.class,false);

    }
}
