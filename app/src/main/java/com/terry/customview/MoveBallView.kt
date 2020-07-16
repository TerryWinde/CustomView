package com.terry.customview

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlin.math.abs

/**
 * Create by xiongfeng on 2020/7/16 0016
 */
class MoveBallView : View {
    var currentX = 0f
    var currentY = 0f
    var radius = 100f
    var paint: Paint? = null
    var pointX = 0f
    var pointY = 0f
    var isDraw = false
    private var height = 0f
    private var width = 0f

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        paint = Paint()
        paint?.isAntiAlias = true
        //拿屏幕的宽高
        val metrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
        width = metrics.widthPixels.toFloat()
        height = metrics.heightPixels.toFloat()
        currentX = (width - radius - 100)
        currentY = (height - radius - 300)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint?.color = Color.GREEN
        canvas.drawCircle(currentX, currentY, radius.toFloat(), paint!!)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                pointX = event.x
                pointY = event.y
                if (currentX + radius > pointX && currentX - radius < pointX && currentY + radius > pointY && currentY - radius < pointY) {
                    isDraw = true
                } else {
                    return false
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (isDraw) {
                    currentX = event.x
                    currentY = event.y
                    if (currentX < radius) currentX = radius
                    if (currentX > width - radius) currentX = width - radius
                    if (currentY < radius) currentY = radius
                    if (currentY > height - radius) currentY = height - radius
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                if (abs(event.x - pointX) < 10 || abs(event.y - pointY) < 10) performClick()
                isDraw = false
                return false
            }
        }
        return true
    }
}