package com.libandexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liband.BaseActivity;
import com.liband.constants.TagsName;
import com.liband.utils.DrawablesUtil;
import com.liband.utils.Utils;
import com.libandexample.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding activityMainBinding;


    @Override
    public void initView() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DrawablesUtil.changeBackgroundDrawable(activityMainBinding.editText, getResources().getColor(android.R.color.transparent),
                getResources().getColor(android.R.color.black), 10, 20);
        startAnotherActivity(Main2Activity.class,false);

    }
}
