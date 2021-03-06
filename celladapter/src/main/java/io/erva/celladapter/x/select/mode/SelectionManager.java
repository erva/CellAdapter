package io.erva.celladapter.x.select.mode;

import java.util.Set;

import androidx.recyclerview.widget.RecyclerView;
import io.erva.celladapter.x.select.SelectableCellAdapter;

public abstract class SelectionManager {

    protected RecyclerView.Adapter adapter;
    private Set<Integer> selectedPositions;

    public void setAdapter(SelectableCellAdapter adapter) {
        this.adapter = adapter;
    }

    public void setSelectedPositions(Set<Integer> selectedPositions) {
        this.selectedPositions = selectedPositions;
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
                adapter.notifyItemChanged(position);
        }
        selectedPositions.clear();
    }

    public int getSelectedItemCount() {
        return selectedPositions.size();
    }

    public Set<Integer> getSelectedPositions() {
        return selectedPositions;
    }

    public abstract boolean isSelected(int position);
}