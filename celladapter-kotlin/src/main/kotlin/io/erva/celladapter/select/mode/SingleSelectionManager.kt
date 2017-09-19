package io.erva.celladapter.select.mode

class SingleSelectionManager : SelectionManager() {

    override fun toggleSelection(position: Int) {
        adapter.clearSelections(true)
        adapter.toggleSelection(position)
        adapter.notifyItemChanged(position)
    }

    override fun setSelection(position: Int, isSelected: Boolean) {
        adapter.clearSelections(true)
        adapter.setSelection(position, isSelected)
        adapter.notifyItemChanged(position)
    }

    override fun isSelected(position: Int): Boolean {
        return adapter.getSelectedPositions().contains(position)
    }
}