package com.liband;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.liband.utils.LangUtils;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getResources().updateConfiguration
                (LangUtils.INSTANCE.getLocal(this), getApplicationContext().getResources().getDisplayMetrics());
        initView();
    }

    public abstract void initView();

    @Override
    public void onClick(View v) {

    }


    public void addFragment(int containerViewId, Fragment newFragment) {
        final FragmentManager manager = this.getSupportFragmentManager();
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

    private void showDialogFragment(DialogFragment dialogFragment) {
        dialogFragment.show(getSupportFragmentManager(), dialogFragment.getClass().getSimpleName());
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
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        if (navigationIcon != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(navigationIcon);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        } else {

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            toolbar.setNavigationOnClickListener(v -> {

                if (!drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.openDrawer(Gravity.START);
                }
            });
        }
    }

}
