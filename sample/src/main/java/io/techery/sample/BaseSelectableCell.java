package io.techery.sample;

import android.view.View;

import butterknife.ButterKnife;
import io.techery.celladapter.Cell;
import io.techery.celladapter.select.SelectableCell;

public abstract class BaseSelectableCell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends SelectableCell<ITEM, LISTENER> {

    public BaseSelectableCell(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}