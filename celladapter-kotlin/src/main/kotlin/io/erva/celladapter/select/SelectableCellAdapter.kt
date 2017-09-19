package io.erva.celladapter.select

import android.view.ViewGroup
import io.erva.celladapter.Cell
import io.erva.celladapter.CellAdapter
import io.erva.celladapter.select.mode.SelectionManager

class SelectableCellAdapter(val selectedPositions: MutableSet<Int> = HashSet<Int>(), val selectionManager: SelectionManager) : CellAdapter() {

    init {
        selectionManager.adapter = this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cell<*, *> {
        val cell = super.onCreateViewHolder(parent, viewType)
        (cell as SelectableCell).selectionManager = selectionManager
        return cell
    }

    fun toggleSelection(position: Int) {
        if (selectedPositions.contains(position))
            selectedPositions.remove(position)
        else
            selectedPositions.add(position)
    }

    fun setSelection(position: Int, isSelected: Boolean) {
        if (isSelected)
            selectedPositions.add(position)
        else
            selectedPositions.remove(position)
    }

    fun clearSelections(notify: Boolean) {
        if (notify) {
            for (position in selectedPositions)
                notifyItemChanged(position)
        }
        selectedPositions.clear()
    }

    fun getSelectedItemCount(): Int {
        return selectedPositions.size
    }

    fun getSelectedPositions(): Collection<Int> {
        return selectedPositions
    }
}