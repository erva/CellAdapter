package io.erva.celladapter.x.select;

import android.view.View;

import io.erva.celladapter.x.Cell;
import io.erva.celladapter.x.select.mode.SelectionManager;

public abstract class SelectableCell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends Cell<ITEM, LISTENER> {

    protected SelectionManager selectionManager;

    public SelectableCell(View view) {
        super(view);
    }

    public void setSelectionManager(SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
    }
}