package io.erva.celladapter.v7.select.mode

import io.erva.celladapter.v7.select.SelectableCellAdapter

abstract class SelectionManager {

    lateinit var adapter: SelectableCellAdapter
    lateinit var selectedPositions: MutableSet<Int>

    open fun toggleSelection(position: Int) {
        if (selectedPositions.contains(position)) selectedPositions.remove(position)
        else selectedPositions.add(position)
    }

    open fun setSelection(position: Int, isSelected: Boolean) {
        if (isSelected) selectedPositions.add(position)
        else selectedPositions.remove(position)
    }

    fun clearSelections(notify: Boolean) {
        if (notify) {
            for (position in selectedPositions)
                adapter.notifyItemChanged(position)
        }
        selectedPositions.clear()
    }

    fun getSelectedItemCount(): Int = selectedPositions.size

    fun getSelectedPositions(): Collection<Int> = selectedPositions

    abstract fun isSelected(position: Int): Boolean
}