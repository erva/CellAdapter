package io.erva.celladapter.v7

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class Cell<ITEM : Any, out LISTENER : Cell.Listener<ITEM>>(val view: View) : RecyclerView.ViewHolder(view) {

    var item: Any? = null
        set(value) {
            field = value
            bindView()
        }
    private var listener: Any? = null

    init {
        view.setOnClickListener { listener()?.onCellClicked(item()) }
    }

    abstract fun bindView()

    fun item(): ITEM {
        return item as ITEM
    }

    fun item(item: Any) {
        this.item = item
    }

    fun listener(): LISTENER? {
        return listener as LISTENER?
    }

    fun listener(listener: Any?) {
        this.listener = listener
    }

    interface Listener<ITEM : Any> {

        fun onCellClicked(item: ITEM) {
        }
    }
}