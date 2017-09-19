package io.erva.celladapter.select.mode

import io.erva.celladapter.select.SelectableCellAdapter

abstract class SelectionManager {

    lateinit var adapter: SelectableCellAdapter

    abstract fun setSelection(position: Int, isSelected: Boolean)

    abstract fun toggleSelection(position: Int)

    abstract fun isSelected(position: Int): Boolean
}