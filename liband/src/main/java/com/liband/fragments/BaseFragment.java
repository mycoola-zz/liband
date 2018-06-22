package com.liband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liband.utils.LangUtils;


public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public abstract void initView(View view);

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getResources().updateConfiguration(LangUtils.getLocal(getActivity()), getResources().getDisplayMetrics());
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    @Override
    public void onClick(View v) {
    }


    @Override
    public void onResume() {
        super.onResume();
        getResources().updateConfiguration(LangUtils.getLocal(getActivity()), getResources().getDisplayMetrics());
    }


}
