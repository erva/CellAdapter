package io.erva.celladapter.select

import android.view.View

import io.erva.celladapter.Cell
import io.erva.celladapter.select.mode.SelectionManager

abstract class SelectableCell<ITEM : Any, out LISTENER : Cell.Listener<ITEM>>(view: View) : Cell<ITEM, LISTENER>(view) {

    lateinit var selectionManager: SelectionManager
}