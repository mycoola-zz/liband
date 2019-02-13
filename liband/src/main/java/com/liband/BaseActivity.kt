package com.liband

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    abstract fun initView()

    override fun onClick(v: View) {
    }


    fun addFragment(containerViewId: Int, newFragment: Fragment) {
        val manager = this.supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(containerViewId, newFragment, newFragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun addFragment(containerViewId: Int, hideFragment: Fragment, newFragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(containerViewId, newFragment, newFragment.javaClass.simpleName)
        transaction.hide(hideFragment)
        transaction.addToBackStack(hideFragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val manager = supportFragmentManager
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val transaction = manager.beginTransaction()
        transaction.replace(containerViewId, fragment, fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun getcurrentFragment(containerViewId: Int): Fragment? {
        return supportFragmentManager.findFragmentById(containerViewId)
    }

    private fun showDialogFragment(dialogFragment: DialogFragment) {
        dialogFragment.show(supportFragmentManager, dialogFragment.javaClass.simpleName)
    }

    fun updateStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun startAnotherActivity(anotherActivity: Class<*>, withTopClear: Boolean) {
        val intent = Intent(this, anotherActivity)
        if (withTopClear) {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }

    fun setToolbar(toolbar: Toolbar, toolbarTitle: TextView, title: String, color: Int,
                   navigationIcon: Drawable?, drawerLayout: DrawerLayout?) {
        setSupportActionBar(toolbar)
        if (!TextUtils.isEmpty(title)) {
            toolbarTitle.visibility = View.VISIBLE
            toolbarTitle.text = title
        } else {
            toolbarTitle.text = ""
            toolbarTitle.visibility = View.GONE
        }
        toolbar.setBackgroundColor(color)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        if (navigationIcon != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            toolbar.navigationIcon = navigationIcon
            toolbar.setNavigationOnClickListener { onBackPressed() }
        } else {

            supportActionBar!!.setHomeButtonEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

            toolbar.setNavigationOnClickListener {

                if (drawerLayout != null) {
                    if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.openDrawer(GravityCompat.START)
                    }
                }
            }
        }
    }

}
