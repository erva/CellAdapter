package io.techery.celladapter.select.mode;

import java.util.List;

public class MultiSelectionManager extends SelectionManager {

    @Override
    public void toggleSelection(int position) {
        selectableCellAdapter.toggleSelection(position);
        selectableCellAdapter.notifyItemChanged(position);
    }

    @Override
    public void setSelection(int position, boolean isSelected) {
        selectableCellAdapter.setSelection(position, isSelected);
        selectableCellAdapter.notifyItemChanged(position);
    }

    @Override
    public boolean isSelected(int position) {
        return selectableCellAdapter.getSelectedPositions().contains(position);
    }

    public List<Integer> getSelectedPositions() {
        return selectableCellAdapter.getSelectedPositions();
    }

    public boolean isAllSelected() {
        return selectableCellAdapter.getSelectedItemCount() == selectableCellAdapter.getItemCount();
    }

    public void setSelectedPositions(List<Integer> selectionPositions) {
        selectableCellAdapter.clearSelections(false);
        for (Integer position : selectionPositions) {
            selectableCellAdapter.toggleSelection(position);
        }
        selectableCellAdapter.notifyDataSetChanged();
    }

    public void setSelectionForAll(boolean isSelected) {
        for (int position = 0; position < selectableCellAdapter.getItemCount(); position++)
            setSelection(position, isSelected);
    }
}