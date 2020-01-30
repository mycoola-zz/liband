package com.liband;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tJ:\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020\u00052\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007\u00a8\u0006*"}, d2 = {"Lcom/liband/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "addFragment", "", "containerViewId", "", "newFragment", "Landroidx/fragment/app/Fragment;", "hideFragment", "getcurrentFragment", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "replaceFragment", "fragment", "setToolbar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "toolbarTitle", "Landroid/widget/TextView;", "title", "", "color", "navigationIcon", "Landroid/graphics/drawable/Drawable;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "showDialogFragment", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "startAnotherActivity", "anotherActivity", "Ljava/lang/Class;", "withTopClear", "", "updateStatusBarColor", "liband_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract void initView();
    
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
    
    public final void updateStatusBarColor(int color) {
    }
    
    public final void startAnotherActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> anotherActivity, boolean withTopClear) {
    }
    
    public final void setToolbar(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.Toolbar toolbar, @org.jetbrains.annotations.NotNull()
    android.widget.TextView toolbarTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int color, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable navigationIcon, @org.jetbrains.annotations.Nullable()
    androidx.drawerlayout.widget.DrawerLayout drawerLayout) {
    }
    
    public BaseActivity() {
        super();
    }
}