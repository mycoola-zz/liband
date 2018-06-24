package com.liband;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.liband.utils.LangUtils;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getResources().updateConfiguration
                (LangUtils.getLocal(this), getApplicationContext().getResources().getDisplayMetrics());
        initView();
    }

    public abstract void initView();

    @Override
    public void onClick(View v) {

    }


    public void addFragment(int containerViewId, Fragment newFragment) {
        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerViewId, newFragment, newFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    public void addFragmentWithHideAnotherFragment(int containerViewId, Fragment hideFragment, Fragment newFragment) {
        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerViewId, newFragment, newFragment.getClass().getSimpleName());
        transaction.hide(hideFragment);
        transaction.addToBackStack(hideFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    public void replaceFragment(int containerViewId, Fragment fragment) {
        final FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerViewId, fragment, fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    public void updateStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    public void startAnotherActivity(Class anotherActivity) {
        final Intent intent = new Intent(this, anotherActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
