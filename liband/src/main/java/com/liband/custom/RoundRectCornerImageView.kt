package com.liband.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatImageView


class RoundRectCornerImageView : AppCompatImageView {

    private var path: Path? = null
    private var rect: RectF? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        path = Path()
        rect = RectF()
    }

    override fun onDraw(canvas: Canvas) {
        rect!!.set(0f, 0f, this.width.toFloat(), this.height.toFloat())
        val radius = 14.0f
        path!!.addRoundRect(rect, radius, radius, Path.Direction.CW)
        canvas.clipPath(path!!)
        super.onDraw(canvas)
    }
}