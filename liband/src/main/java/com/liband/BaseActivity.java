package com.liband;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
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

    public void addFragment(int containerViewId, Fragment hideFragment, Fragment newFragment) {
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

    public Fragment getcurrentFragment(int containerViewId) {
        return getSupportFragmentManager().findFragmentById(containerViewId);
    }

    public void updateStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    public void startAnotherActivity(Class anotherActivity, boolean withTopClear) {
        final Intent intent = new Intent(this, anotherActivity);
        if (withTopClear) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
    }

    public void setToolbar(Toolbar toolbar, TextView toolbarTitle, final String title, int color,
                           final Drawable navigationIcon, final DrawerLayout drawerLayout) {
        setSupportActionBar(toolbar);
        if (!TextUtils.isEmpty(title)) {
            toolbarTitle.setVisibility(View.VISIBLE);
            toolbarTitle.setText(title);
        } else {
            toolbarTitle.setText("");
            toolbarTitle.setVisibility(View.GONE);
        }
        toolbar.setBackgroundColor(color);

        toolbar.setNavigationIcon(navigationIcon);
        if (navigationIcon != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!drawerLayout.isDrawerOpen(Gravity.START)) {
                        drawerLayout.openDrawer(Gravity.START);
                    }
                }
            });
        }
    }

}
