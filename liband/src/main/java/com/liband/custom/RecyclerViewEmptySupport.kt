package com.liband.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar

import androidx.recyclerview.widget.RecyclerView

class RecyclerViewEmptySupport : RecyclerView {
    private var emptyView: View? = null
    var progressbar: ProgressBar? = null

    private val emptyObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            val adapter = adapter
            if (adapter != null && emptyView != null && progressbar != null) {
                if (adapter.itemCount == 0) {
                    progressbar!!.visibility = View.VISIBLE
                    emptyView!!.visibility = View.VISIBLE
                    this@RecyclerViewEmptySupport.visibility = View.GONE


                } else {
                    progressbar!!.visibility = View.GONE
                    emptyView!!.visibility = View.GONE
                    this@RecyclerViewEmptySupport.visibility = View.VISIBLE
                }
            }
        }
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        super.setAdapter(adapter)

        adapter?.registerAdapterDataObserver(emptyObserver)

        emptyObserver.onChanged()
    }

    fun setEmptyView(emptyView: View) {
        this.emptyView = emptyView
    }

    fun removeEmptyView() {
        this.emptyView = null
    }

    fun removeProgressbar() {
        this.progressbar = null
    }
}