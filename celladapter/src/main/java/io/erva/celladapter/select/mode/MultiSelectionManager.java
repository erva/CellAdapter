package io.erva.celladapter.select.mode;

import java.util.List;

public class MultiSelectionManager extends SelectionManager {

    @Override
    public void toggleSelection(Integer position) {
        super.toggleSelection(position);
        adapter.notifyItemChanged(position);
    }

    @Override
    public void setSelection(Integer position, boolean isSelected) {
        super.setSelection(position, isSelected);
        adapter.notifyItemChanged(position);
    }

    @Override
    public boolean isSelected(int position) {
        return getSelectedPositions().contains(position);
    }

    public boolean isAllSelected() {
        return getSelectedItemCount() == adapter.getItemCount();
    }

    public void setSelectedPositions(List<Integer> selectionPositions) {
        clearSelections(false);
        for (Integer position : selectionPositions) toggleSelection(position);
        adapter.notifyDataSetChanged();
    }

    public void setSelectionForAll(boolean isSelected) {
        for (int position = 0; position < adapter.getItemCount(); position++)
            setSelection(position, isSelected);
    }
}