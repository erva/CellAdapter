package io.erva.celladapter.x.select

import android.view.ViewGroup
import io.erva.celladapter.x.Cell
import io.erva.celladapter.x.CellAdapter
import io.erva.celladapter.x.select.mode.SelectionManager

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