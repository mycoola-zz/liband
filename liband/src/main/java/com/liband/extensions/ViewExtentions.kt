package com.liband.extensions

import android.view.View
import android.widget.TextView

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.setVisibility(value: Boolean) = if (value) visible() else gone()

fun TextView?.isNotEmpty(): Boolean {
    return this?.text.toString().trim().isNotEmpty()
}

fun TextView?.isEmpty(): Boolean {
    return this?.text.toString().trim().isEmpty()
}

fun View.enableView() {
    isEnabled = true
    isClickable = true
}

fun View.disableView() {
    isEnabled = false
    isClickable = false
}