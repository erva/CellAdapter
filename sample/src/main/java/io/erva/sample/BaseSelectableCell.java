package io.erva.sample;

import android.view.View;

import butterknife.ButterKnife;
import io.erva.celladapter.Cell;
import io.erva.celladapter.select.SelectableCell;

public abstract class BaseSelectableCell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends SelectableCell<ITEM, LISTENER> {

    public BaseSelectableCell(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}