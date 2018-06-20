package io.erva.celladapter.v7.select;

import android.view.ViewGroup;

import java.util.HashSet;
import java.util.Set;

import io.erva.celladapter.v7.Cell;
import io.erva.celladapter.v7.CellAdapter;
import io.erva.celladapter.v7.select.mode.SelectionManager;

public class SelectableCellAdapter extends CellAdapter {

    private SelectionManager selectionManager;

    public SelectableCellAdapter(SelectionManager selectionManager) {
        this(new HashSet<Integer>(), selectionManager);
    }

    public SelectableCellAdapter(Set<Integer> selectedPositions, SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
        this.selectionManager.setSelectedPositions(selectedPositions);
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
}