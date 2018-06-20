package io.erva.celladapter.x.select.mode;

public class SingleSelectionManager extends SelectionManager {

    @Override
    public void toggleSelection(Integer position) {
        clearSelections(true);
        super.toggleSelection(position);
        adapter.notifyItemChanged(position);
    }

    @Override
    public void setSelection(Integer position, boolean isSelected) {
        clearSelections(true);
        super.setSelection(position, isSelected);
        adapter.notifyItemChanged(position);
    }

    @Override
    public boolean isSelected(int position) {
        return getSelectedPositions().contains(position);
    }

    public Integer getSelectedPosition() {
        return getSelectedPositions().isEmpty()? -1 : getSelectedPositions().iterator().next();
    }
}