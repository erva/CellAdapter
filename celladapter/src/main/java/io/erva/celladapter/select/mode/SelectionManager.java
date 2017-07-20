package io.erva.celladapter.select.mode;

import io.erva.celladapter.select.SelectableCellAdapter;

public abstract class SelectionManager {

    protected SelectableCellAdapter selectableCellAdapter;

    public final void setAdapter(SelectableCellAdapter selectableCellAdapter) {
        this.selectableCellAdapter = selectableCellAdapter;
    }

    public abstract void setSelection(int position, boolean isSelected);

    public abstract void toggleSelection(int position);

    public abstract boolean isSelected(int position);
}