package com.liband.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


abstract class BaseFragment : Fragment(), View.OnClickListener {


    abstract fun initView(view: View?)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

    }

    override fun onClick(v: View) {}


    fun addFragment(containerViewId: Int, newFragment: Fragment) {
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(containerViewId, newFragment, newFragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun addFragment(containerViewId: Int, hideFragment: Fragment, newFragment: Fragment) {
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(containerViewId, newFragment, newFragment.javaClass.simpleName)
        transaction.hide(hideFragment)
        transaction.addToBackStack(hideFragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val manager = childFragmentManager
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val transaction = manager.beginTransaction()
        transaction.replace(containerViewId, fragment, fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun getcurrentFragment(containerViewId: Int): Fragment? {
        return childFragmentManager.findFragmentById(containerViewId)
    }

    private fun showDialogFragment(dialogFragment: DialogFragment) {
        dialogFragment.show(activity!!.supportFragmentManager, dialogFragment.javaClass.simpleName)
    }

}
