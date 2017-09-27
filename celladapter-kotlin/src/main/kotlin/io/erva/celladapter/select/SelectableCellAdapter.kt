package io.erva.celladapter.select

import android.view.ViewGroup
import io.erva.celladapter.Cell
import io.erva.celladapter.CellAdapter
import io.erva.celladapter.select.mode.SelectionManager

class SelectableCellAdapter(private val selectedPositions: MutableSet<Int> = HashSet<Int>(), val selectionManager: SelectionManager) : CellAdapter() {

    init {
        selectionManager.adapter = this
        selectionManager.selectedPositions = selectedPositions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cell<*, *> {
        val cell = super.onCreateViewHolder(parent, viewType)
        (cell as SelectableCell).selectionManager = selectionManager
        return cell
    }
}