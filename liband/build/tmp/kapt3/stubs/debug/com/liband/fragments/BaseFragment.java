package com.liband.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/liband/fragments/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "addFragment", "", "containerViewId", "", "newFragment", "hideFragment", "getcurrentFragment", "initView", "view", "Landroid/view/View;", "onClick", "v", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "replaceFragment", "fragment", "showDialogFragment", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "liband_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    
    public abstract void initView(@org.jetbrains.annotations.Nullable()
    android.view.View view);
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void addFragment(int containerViewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment newFragment) {
    }
    
    public final void addFragment(int containerViewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment hideFragment, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment newFragment) {
    }
    
    public final void replaceFragment(int containerViewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.fragment.app.Fragment getcurrentFragment(int containerViewId) {
        return null;
    }
    
    private final void showDialogFragment(androidx.fragment.app.DialogFragment dialogFragment) {
    }
    
    public BaseFragment() {
        super();
    }
}