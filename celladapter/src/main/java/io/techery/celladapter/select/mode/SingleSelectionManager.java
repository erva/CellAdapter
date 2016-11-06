package io.techery.celladapter.select.mode;

public class SingleSelectionManager extends SelectionManager {

    @Override
    public void toggleSelection(int position) {
        selectableCellAdapter.clearSelections(true);
        selectableCellAdapter.toggleSelection(position);
        selectableCellAdapter.notifyItemChanged(position);
    }

    @Override
    public void setSelection(int position, boolean isSelected) {
        selectableCellAdapter.clearSelections(true);
        selectableCellAdapter.setSelection(position, isSelected);
        selectableCellAdapter.notifyItemChanged(position);
    }

    @Override
    public boolean isSelected(int position) {
        return selectableCellAdapter.getSelectedPositions().contains(position);
    }
}