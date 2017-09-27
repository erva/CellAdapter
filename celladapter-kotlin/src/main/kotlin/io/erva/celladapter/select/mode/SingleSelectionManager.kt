package io.erva.celladapter.select.mode

class SingleSelectionManager : SelectionManager() {

    override fun toggleSelection(position: Int) {
        clearSelections(true)
        super.toggleSelection(position)
        adapter.notifyItemChanged(position)
    }

    override fun setSelection(position: Int, isSelected: Boolean) {
        clearSelections(true)
        super.setSelection(position, isSelected)
        adapter.notifyItemChanged(position)
    }

    override fun isSelected(position: Int): Boolean {
        return getSelectedPositions().contains(position)
    }

    fun getSelectedPosition(): Int? {
        return if (getSelectedPositions().isEmpty()) -1 else getSelectedPositions().iterator().next()
    }
}