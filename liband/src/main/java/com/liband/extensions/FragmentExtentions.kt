package com.liband.extensions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun Fragment.addFragment(containerViewId: Int, newFragment: Fragment) {
    val manager = childFragmentManager
    val transaction = manager.beginTransaction()
    transaction.add(containerViewId, newFragment, newFragment.javaClass.simpleName)
    transaction.commitAllowingStateLoss()
}


fun Fragment.addFragment(containerViewId: Int, hideFragment: Fragment, newFragment: Fragment) {
    val manager = childFragmentManager
    val transaction = manager.beginTransaction()
    transaction.add(containerViewId, newFragment, newFragment.javaClass.simpleName)
    transaction.hide(hideFragment)
    transaction.addToBackStack(hideFragment.javaClass.simpleName)
    transaction.commitAllowingStateLoss()
}

fun Fragment.replaceFragment(containerViewId: Int, fragment: Fragment) {
    val manager = childFragmentManager
    manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    val transaction = manager.beginTransaction()
    transaction.replace(containerViewId, fragment, fragment.javaClass.simpleName)
    transaction.commitAllowingStateLoss()
}

fun Fragment.getcurrentFragment(containerViewId: Int): Fragment? {
    return childFragmentManager.findFragmentById(containerViewId)
}

fun Fragment?.runOnUiThread(action: () -> Unit) {
    this ?: return
    if (!isAdded) return
    activity?.runOnUiThread(action)
}



