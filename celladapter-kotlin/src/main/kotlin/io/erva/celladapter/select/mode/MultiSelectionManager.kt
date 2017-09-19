package io.erva.celladapter.select.mode

class MultiSelectionManager : SelectionManager() {

    override fun toggleSelection(position: Int) {
        adapter.toggleSelection(position)
        adapter.notifyItemChanged(position)
    }

    override fun setSelection(position: Int, isSelected: Boolean) {
        adapter.setSelection(position, isSelected)
        adapter.notifyItemChanged(position)
    }

    override fun isSelected(position: Int): Boolean {
        return adapter.getSelectedPositions().contains(position)
    }

    fun getSelectedPositions(): Collection<Int> {
        return adapter.getSelectedPositions()
    }

    fun isAllSelected(): Boolean {
        return adapter.getSelectedItemCount() == adapter.itemCount
    }

    fun setSelectedPositions(selectionPositions: List<Int>) {
        adapter.clearSelections(false)
        for (position in selectionPositions) {
            adapter.toggleSelection(position)
        }
        adapter.notifyDataSetChanged()
    }

    fun setSelectionForAll(isSelected: Boolean) {
        for (position in 0..adapter.itemCount - 1)
            setSelection(position, isSelected)
    }
}