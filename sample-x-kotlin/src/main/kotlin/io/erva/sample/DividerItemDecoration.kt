package io.erva.sample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration : RecyclerView.ItemDecoration {

    private var divider: Drawable? = null

    constructor(context: Context) {
        val a = context.obtainStyledAttributes(intArrayOf(android.R.attr.listDivider))
        divider = a.getDrawable(0)
        a.recycle()
    }

    constructor(divider: Drawable) {
        this.divider = divider
    }

    constructor(context: Context, @DrawableRes drawableId: Int) {
        divider = ResourcesCompat.getDrawable(context.resources, drawableId, null)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        if (divider == null) return
        if (parent.getChildAdapterPosition(view) < 1) return

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL)
            outRect.top = divider!!.intrinsicHeight
        else
            outRect.left = divider!!.intrinsicWidth
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (divider == null) {
            super.onDrawOver(c, parent, state)
            return
        }

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            val left = parent.paddingLeft
            val right = parent.width - parent.paddingRight
            val childCount = parent.childCount

            for (i in 1..childCount - 1) {
                val child = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams
                val size = divider!!.intrinsicHeight
                val top = child.top - params.topMargin
                val bottom = top + size
                divider!!.setBounds(left, top, right, bottom)
                divider!!.draw(c)
            }
        } else { //horizontal
            val top = parent.paddingTop
            val bottom = parent.height - parent.paddingBottom
            val childCount = parent.childCount

            for (i in 1..childCount - 1) {
                val child = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams
                val size = divider!!.intrinsicWidth
                val left = child.left - params.leftMargin
                val right = left + size
                divider!!.setBounds(left, top, right, bottom)
                divider!!.draw(c)
            }
        }
    }

    private fun getOrientation(parent: RecyclerView): Int {
        if (parent.layoutManager is LinearLayoutManager) {
            val layoutManager = parent.layoutManager as LinearLayoutManager
            return layoutManager.orientation
        } else
            throw IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.")
    }
}