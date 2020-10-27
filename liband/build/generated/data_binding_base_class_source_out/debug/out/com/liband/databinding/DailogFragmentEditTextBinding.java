// Generated by data binding compiler. Do not edit!
package com.liband.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.liband.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DailogFragmentEditTextBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout editName;

  @NonNull
  public final EditText txtYourName;

  protected DailogFragmentEditTextBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout editName, EditText txtYourName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.editName = editName;
    this.txtYourName = txtYourName;
  }

  @NonNull
  public static DailogFragmentEditTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dailog_fragment_edit_text, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DailogFragmentEditTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DailogFragmentEditTextBinding>inflateInternal(inflater, R.layout.dailog_fragment_edit_text, root, attachToRoot, component);
  }

  @NonNull
  public static DailogFragmentEditTextBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dailog_fragment_edit_text, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DailogFragmentEditTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DailogFragmentEditTextBinding>inflateInternal(inflater, R.layout.dailog_fragment_edit_text, null, false, component);
  }

  public static DailogFragmentEditTextBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static DailogFragmentEditTextBinding bind(@NonNull View view, @Nullable Object component) {
    return (DailogFragmentEditTextBinding)bind(component, view, R.layout.dailog_fragment_edit_text);
  }
}