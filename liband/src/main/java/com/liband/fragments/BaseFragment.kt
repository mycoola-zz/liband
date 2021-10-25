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


}
