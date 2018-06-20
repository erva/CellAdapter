package io.erva.celladapter.v7.select

import android.view.View
import io.erva.celladapter.v7.Cell
import io.erva.celladapter.v7.select.mode.SelectionManager

abstract class SelectableCell<ITEM : Any, out LISTENER : Cell.Listener<ITEM>>(view: View) : Cell<ITEM, LISTENER>(view) {

    lateinit var selectionManager: SelectionManager
}