package io.techery.celladapter.select;

import android.view.ViewGroup;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.techery.celladapter.Cell;
import io.techery.celladapter.CellAdapter;
import io.techery.celladapter.select.mode.SelectionManager;

public class SelectableCellAdapter extends CellAdapter {

    private Set<Integer> selectedPositions;
    private SelectionManager selectionManager;

    public SelectableCellAdapter(SelectionManager selectionManager) {
        this(new HashSet<Integer>(), selectionManager);
    }

    public SelectableCellAdapter(Set<Integer> selectedPositions, SelectionManager selectionManager) {
        this.selectedPositions = selectedPositions;
        this.selectionManager = selectionManager;
        this.selectionManager.setAdapter(this);
    }

    @Override
    public Cell onCreateViewHolder(ViewGroup parent, int viewType) {
        Cell cell = super.onCreateViewHolder(parent, viewType);
        if (cell instanceof SelectableCell) {
            ((SelectableCell) cell).setSelectionManager(selectionManager);
        }
        return cell;
    }

    public void toggleSelection(Integer position) {
        if (selectedPositions.contains(position)) selectedPositions.remove(position);
        else selectedPositions.add(position);
    }

    public void setSelection(Integer position, boolean isSelected) {
        if (isSelected) selectedPositions.add(position);
        else selectedPositions.remove(position);
    }

    public void clearSelections(boolean notify) {
        if (notify) {
            for (int position : selectedPositions)
                notifyItemChanged(position);
        }
        selectedPositions.clear();
    }

    public int getSelectedItemCount() {
        return selectedPositions.size();
    }

    public Collection<Integer> getSelectedPositions() {
        return selectedPositions;
    }
}