package io.erva.sample.home

import android.view.View
import android.widget.TextView

import io.erva.celladapter.Cell
import io.erva.celladapter.Layout

@Layout(android.R.layout.simple_list_item_1)
class MenuItemCell(view: View) : Cell<MenuItemModel, Cell.Listener<MenuItemModel>>(view) {

    override fun bindView() {
        val item = item()
        (view.findViewById(android.R.id.text1) as TextView).setText(item.titleId)
    }
}