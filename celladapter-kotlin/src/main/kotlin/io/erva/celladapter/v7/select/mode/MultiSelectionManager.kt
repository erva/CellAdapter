package io.erva.celladapter.v7.select.mode

class MultiSelectionManager : SelectionManager() {

    override fun toggleSelection(position: Int) {
        super.toggleSelection(position)
        adapter.notifyItemChanged(position)
    }

    override fun setSelection(position: Int, isSelected: Boolean) {
        super.setSelection(position, isSelected)
        adapter.notifyItemChanged(position)
    }

    override fun isSelected(position: Int): Boolean {
        return getSelectedPositions().contains(position)
    }

    fun isAllSelected(): Boolean {
        return getSelectedItemCount() == adapter.itemCount
    }

    fun setSelectedPositions(selectionPositions: List<Int>) {
        clearSelections(false)
        for (position in selectionPositions) toggleSelection(position)
        adapter.notifyDataSetChanged()
    }

    fun setSelectionForAll(isSelected: Boolean) {
        for (position in 0 until adapter.itemCount)
            setSelection(position, isSelected)
    }
}