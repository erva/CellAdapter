package io.erva.celladapter.x.select

import android.view.View

import io.erva.celladapter.x.Cell
import io.erva.celladapter.x.select.mode.SelectionManager

abstract class SelectableCell<ITEM : Any, out LISTENER : Cell.Listener<ITEM>>(view: View) : Cell<ITEM, LISTENER>(view) {

    lateinit var selectionManager: SelectionManager
}