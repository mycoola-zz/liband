package com.liband.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liband.utils.LangUtils;

import java.util.Objects;


public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public abstract void initView(View view);

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getResources().updateConfiguration(LangUtils.getLocal(Objects.requireNonNull(getActivity())), getResources().getDisplayMetrics());
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    @Override
    public void onClick(View v) {
    }


    @Override
    public void onResume() {
        super.onResume();
        getResources().updateConfiguration(LangUtils.getLocal(Objects.requireNonNull(getActivity())), getResources().getDisplayMetrics());
    }


    public void addFragment(int containerViewId, Fragment newFragment) {
        final FragmentManager manager = getChildFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerViewId, newFragment, newFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    public void addFragment(int containerViewId, Fragment hideFragment, Fragment newFragment) {
        final FragmentManager manager = getChildFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerViewId, newFragment, newFragment.getClass().getSimpleName());
        transaction.hide(hideFragment);
        transaction.addToBackStack(hideFragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    public void replaceFragment(int containerViewId, Fragment fragment) {
        final FragmentManager manager = getChildFragmentManager();
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerViewId, fragment, fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }

    public Fragment getcurrentFragment(int containerViewId) {
        return getChildFragmentManager().findFragmentById(containerViewId);
    }

    private void showDialogFragment(DialogFragment dialogFragment) {
        dialogFragment.show(getActivity().getSupportFragmentManager(), dialogFragment.getClass().getSimpleName());
    }

}
